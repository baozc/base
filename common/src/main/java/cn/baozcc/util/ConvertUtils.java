package cn.baozcc.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import cn.baozcc.me.annotation.ConvertClass;
import cn.baozcc.me.annotation.ConvertField;


/**
 * swagger-ui model 转换工具
 *
 * @author baozc
 * @date 2018年9月6日 上午11:17:00
 */
public class ConvertUtils {

    /**
     * 转换源class为 swagger-ui model<br>
     * <strong>根据注解判断转换的类</strong>
     * @param source 目标源
     * @throws Exception
     * @auth baozc
     * @date 2018年9月6日 上午11:19:06
     */
    /**
     * //TODO
     *
     * @param source
     * @return java.lang.Object
     * @author baozc
     * @date 12:41 AM 2018/11/4
     **/
    public static Object clone(Object source) throws Exception {
        return clone(source, null);
    }

    /**
     * 转换源class为 type 指定类型<br>
     *
     * @param source 目标源
     * @param type   判断类型
     * @throws Exception
     * @auth baozc
     * @date 2018年9月6日 上午11:19:06
     */
    public static Object clone(Object source, String type) throws Exception {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass;
        Object target;

        if (type == null) {
            type = "swagger";
        }

        if (sourceClass.isAnnotationPresent(ConvertClass.class)) {
            ConvertClass cc = sourceClass.getAnnotation(ConvertClass.class);
            targetClass = getTargetClass(type, cc);
            target = targetClass.newInstance();
        } else {
            throw new RuntimeException("not fount Annotation ConvertClass");
        }
        /*转换对应字段的值*/
        Field[] sourceFields = sourceClass.getDeclaredFields();
        for (Field field : sourceFields) {

            if (field.isAnnotationPresent(ConvertField.class)) {

                field.setAccessible(true);
                ConvertField cf = field.getAnnotation(ConvertField.class);
                String fieldName = getFieldName(type, cf);

                if (fieldName.equals(""))
                    continue;

                if (!cf.isArray()) {

                    setFieldValue(source, targetClass, target, fieldName).set(target, field.get(source));

                } else if (cf.isArray() && field.getType().isAssignableFrom(List.class)) {//arraylist

                    Object objl = field.get(source);
                    if (objl == null)
                        continue;

                    @SuppressWarnings("unchecked")
                    List<Object> list = (List<Object>) objl;

                    List<Object> targetList = new ArrayList<Object>();
                    for (Object obj : list) {
                        targetList.add(clone(obj, type));
                    }

                    setFieldValue(source, targetClass, target, fieldName).set(target, targetList);

                }

            }


        }
        Method[] sourceMethods = sourceClass.getDeclaredMethods();
        for (Method method : sourceMethods) {
            if (!method.getGenericReturnType().equals("void"))
                if (method.isAnnotationPresent(ConvertField.class)) {
                    method.setAccessible(true);
                    Object methodReturn = method.invoke(source);
                    ConvertField cf = method.getAnnotation(ConvertField.class);
                    String fieldName = getFieldName(type, cf);

                    if ("".equals(fieldName))
                        continue;

                    setFieldValue(source, targetClass, target, fieldName).set(target, methodReturn);
                }
        }
        return target;
    }

    /**
     * 获取字段名称
     *
     * @param type 判断类型
     * @param cf   注解
     * @return 字段名称
     * @auth baozc
     * @date 2018年9月12日 下午4:21:55
     */
    private static String getFieldName(String type, ConvertField cf) {
        String fieldName;
            fieldName = cf.value();
        return fieldName;
    }

    /**
     * 获取目标类
     *
     * @param type 判断类型
     * @param cc   注解
     * @return 目标类
     * @auth baozc
     * @date 2018年9月12日 下午4:20:47
     */
    private static Class<?> getTargetClass(String type, ConvertClass cc) {
        Class<?> targetClass;
            targetClass = cc.value();
        return targetClass;
    }

    /**
     * 设置目标类的字段值
     *
     * @param source      源对象
     * @param targetClass 目标类
     * @param target      目标对象
     * @param fieldName       字段属性
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @auth baozc
     * @date 2018年9月10日 下午5:55:20
     */
    private static Field setFieldValue(Object source, Class<?> targetClass, Object target, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {

        Field targetField = targetClass.getDeclaredField(fieldName);
        targetField.setAccessible(true);
        return targetField;
    }

    /**
     * 转换类型为注解定义的类型
     *
     * @param list 对象集合
     * @throws Exception
     * @auth baozc
     * @date 2018年9月12日 上午9:48:12
     */
    public static List<Object> clone(List<?> list) throws Exception {
        List<Object> listObj = new ArrayList<Object>();
        for (Object obj : list) {
            Object o = clone(obj, null);
            listObj.add(o);
        }
        return listObj;
    }

    /**
     * 转换类型为注解定义的类型
     *
     * @param list 对象集合
     * @param type 判断类型
     * @throws Exception
     * @auth baozc
     * @date 2018年9月12日 上午9:48:12
     */
    public static List<Object> clone(List<?> list, String type) throws Exception {
        List<Object> listObj = new ArrayList<Object>();
        for (Object obj : list) {
            Object o = clone(obj, type);
            listObj.add(o);
        }
        return listObj;
    }
}
