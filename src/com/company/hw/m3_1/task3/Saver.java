package com.company.hw.m3_1.task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Saver {
    public static void save(Class<?>...ls) {
        for (Class<?> cls : ls) {
            if (cls.isAnnotationPresent(SaveToFile.class)) {
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(SaveMethod.class)) {
                        try {
                            SaveToFile saveToFile = cls.getAnnotation(SaveToFile.class);
                            method.invoke(null, saveToFile.value());
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
