package com.makun.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * @author Created by makun
 * @Date 2018/6/2.
 */
@Target(FIELD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    int id() default 0;

    String address() default "";

    String name() default "";
}
