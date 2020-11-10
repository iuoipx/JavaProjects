package com.iuoip.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */

@Target({ElementType.TYPE,ElementType.METHOD}) //TYPE表示只能在类,接口上使用
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name() default "default value"; //注解变量，不是方法。default参数默认值

    String[] colleage();

    //String value() default "default value";  //只有一个值时，使用value直接写值
}
