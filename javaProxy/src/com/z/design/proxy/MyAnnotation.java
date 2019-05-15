package com.z.design.proxy;

import java.lang.annotation.*;

/**
 * User: zhangkb
 * Date: 2019/1/17 0017
 * Time: 下午 4:13
 */
@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    public String value() default "xiaobao";
}
