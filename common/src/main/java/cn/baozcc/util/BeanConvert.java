package cn.baozcc.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cn.baozcc.me.annotation.ConvertClass;
import cn.baozcc.me.annotation.ConvertField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;


/**
 * 类转换工具
 *
 * @author baozc
 * @date 2019年12月23日 14:29:06
 */
@Slf4j
public class BeanConvert {

    private static List<String> types;

    static {
        String[] type = {"java.lang.Integer",
                "java.lang.Double",
                "java.lang.Float",
                "java.lang.Long",
                "java.lang.Short",
                "java.lang.Byte",
                "java.lang.Boolean",
                "java.lang.Character",
                "java.lang.String",
                "int", "double", "long", "short", "byte", "boolean", "char", "float"};
        //noinspection unchecked
        types = new ArrayList<>(CollectionUtils.arrayToList(type));
    }

    /**
     * 转换源class<br>
     * <strong>根据注解判断转换的类</strong>
     *
     * @param source 源实例
     * @return
     * @author baozc
     * @date 2019年12月23日 11:53:32
     */
    @SuppressWarnings("unused")
    public <T> T clone(Object source) {
        Class<?> sourceClass = source.getClass();
        Class<T> targetClass;

        if (sourceClass.isAnnotationPresent(ConvertClass.class)) {
            ConvertClass cc = sourceClass.getAnnotation(ConvertClass.class);
            //noinspection unchecked
            targetClass = (Class<T>) cc.value();
        } else {
            throw new RuntimeException("not fount targetClass");
        }
        return clone(source, targetClass);
    }

    /**
     * 转换类型为注解定义的类型
     *
     * @param list 对象集合
     * @param targetClass 目标类型
     * @throws Exception
     * @auth baozc
     * @date 2018年9月12日 上午9:48:12
     */
    public <T, S> List<T> clone(List<S> list, Class<T> targetClass) {
        List<T> listObj = new ArrayList<T>();
        for (S obj : list) {
            T o = clone(obj, targetClass);
            listObj.add(o);
        }
        return listObj;
    }

    /**
     * 转换源类为目标类型<br>
     *
     * <strong>忽略final、基本类型不匹配字段、忽略目标字段不存在</strong><br>
     * 如果转换字段类型为自定义类型，根据目标字段类型自动转换<br>
     * 如果转换字段为list，并且自定义类型，根据目标字段自动转换<br>
     * 如果转换字段为list，基本类型，直接赋值
     *
     * @param source 源对象
     * @param targetClass 目标类型
     * @throws Exception
     * @auth baozc
     * @date 2018年9月6日 上午11:19:06
     */
    public <T, R> T clone(Object source, Class<T> targetClass) {
        try {
            T target = targetClass.newInstance();
            if (source == null) {
                log.warn("clone source is null, targetClass class: {}", targetClass);
                return target;
            }
            Class<?> sourceClass = source.getClass();

            /*转换对应字段的值*/
            Field[] sourceFields = sourceClass.getDeclaredFields();
            for (Field field : sourceFields) {

                // 目标字段不存在时，跳过当前循环
                Field targetField;
                try {
                    targetField = getField(targetClass, field);
                } catch (IllegalArgumentException | NoSuchFieldException ignored) {
                    continue;
                }

                // 当前字段值为null时，跳过当前循环
                Object value = field.get(source);
                if (value == null) {
                    continue;
                }

                boolean isBasicType = types.stream().anyMatch(t -> t.equals(field.getType().getName()));
                if (checkField(field, targetField, isBasicType)) {
                    continue;
                }

                if (field.getType().isAssignableFrom(List.class)) {
                    setTargetListField(target, targetField, field, value);
                } else {
                    setTargetField(target, targetField, field, value, isBasicType);
                }

            }

            setFieldByMethod(source, sourceClass, target, targetClass);
            return target;
        } catch (InstantiationException | IllegalAccessException | SecurityException |
                IllegalArgumentException | NoSuchFieldException | InvocationTargetException e) {
            throw new RuntimeException("bean convert exception: " + e.getMessage(), e);
        }
    }

    /**
     * 根据当前对象方法返回值，设置目标字段，需要注解支持
     * @param source
     * @param sourceClass
     * @param target
     * @param targetClass
     * @return
     * @author baozc
     * @date 2020年07月01日 22:14:12
     */
    private <T> void setFieldByMethod(Object source, Class<?> sourceClass, T target, Class<T> targetClass) throws IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Method[] sourceMethods = sourceClass.getDeclaredMethods();
        for (Method method : sourceMethods) {
            //noinspection EqualsBetweenInconvertibleTypes,AliEqualsAvoidNull
            if (!"void".equals(method.getGenericReturnType()) && method.isAnnotationPresent(ConvertField.class)) {

                ConvertField cf = method.getAnnotation(ConvertField.class);
                String fieldName = cf.value();

                if ("".equals(fieldName)) {
                    continue;
                }

                method.setAccessible(true);
                Object methodReturn = method.invoke(source);

                getField(targetClass, fieldName).set(target, methodReturn);
            }
        }
    }

    /**
     * 设置list字段值
     * @param target
     * @param targetField
     * @param field 当前字段值
     * @param value
     * @author baozc
     * @date 2020年07月01日 22:06:43
     */
    private <T> void setTargetListField(T target, Field targetField, Field field, Object value) throws IllegalAccessException {
        List<?> list = (List<?>) value;

        Class<?> targetListClass = getTargetListClass(targetField);
        Class<?> fieldListClass = getTargetListClass(field);

        targetField.set(target, value);

        /**
         * 校验是否基本类型，基本类型直接设置值
         * 校验目标字段类型是否和当前字段类型是否一致，一致直接赋值
         */
        if (types.stream().anyMatch(t -> t.equals(targetListClass.getName())) ||
                targetListClass.getName().equals(fieldListClass.getName())) {
            targetField.set(target, value);
            return;
        }

        setTargetListField(target, targetField, list, targetListClass);
    }

    /**
     * 设置目标字段值
     *
     * 如果目标字段为自定义类型，则自动转换
     * @param target 目标对象
     * @param targetField 目标字段
     * @param field 当前字段
     * @param value 当前字段值
     * @param isBasicType 当前字段是否为基本类型
     * @author baozc
     * @date 2020年07月01日 22:02:25
     */
    private <T> void setTargetField(T target, Field targetField, Field field, Object value, boolean isBasicType) throws IllegalAccessException {
        // 自定义类型时，递归复制
        if (!isBasicType && !field.getType().isEnum()) {
            value = clone(value, targetField.getType());
        }

        targetField.set(target, value);
    }

    /**
     * 设置目标list字段值
     * @param target 目标类
     * @param targetField 目标字段
     * @param listValue 当前list字段值
     * @param targetListClass 目标字段list对应泛型类
     * @return
     * @author baozc
     * @date 2020年07月01日 21:58:39
     */
    private <T> void setTargetListField(T target, Field targetField, List<?> listValue, Class<?> targetListClass) throws IllegalAccessException {
        List<Object> targetList = new ArrayList<>();
        listValue.forEach(v -> targetList.add(clone(v, targetListClass)));
        targetField.set(target, targetList);
    }

    /**
     * 获取目标list字段的泛型
     * @param targetField 目标list字段
     * @return list所对应的泛型
     * @author baozc
     * @date 2020年07月01日 21:57:06
     */
    private Class<?> getTargetListClass(Field targetField) {
        ParameterizedType listGenericType = (ParameterizedType) targetField.getGenericType();
        Type[] listActualTypeArguments = listGenericType.getActualTypeArguments();
        Type type = listActualTypeArguments[listActualTypeArguments.length - 1];

        return (Class<?>) type;
    }

    /**
     * 获取字段名称<br><br>
     *
     * 为防止目标字段名称和当前字段名称不一致，优先使用{@link ConvertField}注解
     *
     * @param field 当前字段
     * @return 字段名称
     * @author baozc
     * @date 2020年07月01日 21:52:50
     */
    private String getFieldName(Field field) {
        String fieldName;// 当前字段有注解时，优先使用注解的字段名称
        if (field.isAnnotationPresent(ConvertField.class)) {
            ConvertField cf = field.getAnnotation(ConvertField.class);
            fieldName = cf.value();
        } else {
            fieldName = field.getName();
        }
        field.setAccessible(true);
        return fieldName;
    }

    /**
     * 校验字段，通过则继续拷贝<br><br>
     *
     * 1. 字段都不为final<br>
     * 2. 基本类型字段类型一致<br>
     * @param field 源字段
     * @param targetField 目标字段
     * @param isBasicType 当前字段是否为基本类型
     * @return 校验结果
     * @author baozc
     * @date 2020年07月01日 21:44:03
     */
    private boolean checkField(Field field, Field targetField, boolean isBasicType) {
        // 判断字段是否是final
        boolean isFinal = Modifier.isFinal(field.getModifiers()) ||
                Modifier.isFinal(targetField.getModifiers());
        // 字段哦噶为基本类型，并且两个字段类型是否一致
        boolean isInstanceof = isBasicType && field.getType() != targetField.getType();

        return isFinal || isInstanceof;
    }

    /**
     * 设置目标类的字段值
     *
     * @param source      源对象
     * @param targetClass 目标类
     * @param target      目标对象
     * @param fieldName   字段属性
     * @throws NoSuchFieldException
     * @auth baozc
     * @date 2018年9月10日 下午5:55:20
     */
    @SuppressWarnings("unused")
    private static Field getField(Object source, Class<?> targetClass, Object target, String fieldName)
            throws NoSuchFieldException {

        Field targetField = targetClass.getDeclaredField(fieldName);
        targetField.setAccessible(true);
        return targetField;
    }

    /**
     * 获取目标类的字段
     *
     * @param targetClass 目标类
     * @param field 当前对象字段
     * @throws NoSuchFieldException
     * @auth baozc
     * @date 2018年9月10日 下午5:55:20
     */
    @SuppressWarnings({"RedundantThrows", "InfiniteRecursion"})
    private Field getField(Class<?> targetClass, Field field)
            throws NoSuchFieldException {

        String fieldName = getFieldName(field);

        return getField(targetClass, fieldName);
    }

    private Field getField(Class<?> targetClass, String fieldName)
            throws NoSuchFieldException {

        Field targetField = targetClass.getDeclaredField(fieldName);
        targetField.setAccessible(true);
        return targetField;
    }
}
