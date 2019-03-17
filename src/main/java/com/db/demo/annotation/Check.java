package com.db.demo.annotation;


import java.lang.annotation.*;


/**
 * aop拦截 用了该注解的方法
 * @author allenpeng
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    String name() default "";
}
