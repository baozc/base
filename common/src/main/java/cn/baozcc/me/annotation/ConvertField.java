package cn.baozcc.me.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 设置字段名称，在两个对象字段名称不一致时使用
 * @author baozc
 * @date 2020年07月01日 22:17:39
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ConvertField {
	
	String value() default "";
	Class type();
	boolean isArray() default false;
}
