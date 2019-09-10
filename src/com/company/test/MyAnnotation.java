package com.company.test;

import java.lang.annotation.*;

@Inherited
//@Target(value = ElementType.TYPE)
@Target(value = {ElementType.TYPE, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String param1() default "string";
    String param2();
}
