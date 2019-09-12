package com.company.hw.m3_1.task2;

import java.lang.reflect.Method;

public class Tester {
    public static boolean test(Class<?>...ls) {
        try {
            for (Class<?> cls : ls) {
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Test.class)) {
                        Test test = method.getAnnotation(Test.class);
                        Boolean b = (Boolean) method.invoke(null, test.value1(), test.value2());
                        if (!b)
                            return false;
                    }
                }
            }

            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
