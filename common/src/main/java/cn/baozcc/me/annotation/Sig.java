package cn.baozcc.me.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auth baozc
 * @date 2019/7/29 6:07 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Sig {

    /**
     * 签名，默认取属性名
     * @author baozc
     * @date 2019年07月29日 18:10:15
     */
    String value() default "";

    /**
     * 是否是sig签名，默认false
     * @param
     * @date 2019年07月29日 18:10:34
     */
    boolean isSig() default false;
}
