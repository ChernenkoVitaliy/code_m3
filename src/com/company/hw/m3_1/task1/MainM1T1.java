package com.company.hw.m3_1.task1;

/*Вывести на экран всю информацию про класс RandomAccessFile(+)*/

import java.io.FileReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MainM1T1 {
    public static void main(String[] args) {
        final Class<?> cls = RandomAccessFile.class;

        System.out.println("Class name: " + cls.getName());

        System.out.print("Modifiers: ");
        int mods = cls.getModifiers();
        if (Modifier.isPrivate(mods))
            System.out.print("private ");
        if (Modifier.isPublic(mods))
            System.out.print("public ");
        if (Modifier.isStatic(mods))
            System.out.print("static ");
        if (Modifier.isFinal(mods))
            System.out.print("final ");
        if (Modifier.isAbstract(mods))
            System.out.print("abstract ");


        System.out.println("\nAll fields: ");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            Class<?> fieldType = field.getType();
            System.out.println("\tName: " + field.getName());
            System.out.println("\tType: " + field.getType().getName() + "\n");
        }

        System.out.println("Constructors: ");
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> ctr : constructors) {
            Class<?>[] paramTypes = ctr.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }
    }
}
