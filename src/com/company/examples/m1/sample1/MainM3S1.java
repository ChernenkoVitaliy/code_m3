package com.company.examples.m1.sample1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MainM3S1 {

    static private final class Test {
        public String p = "Test string";
        private int a  = 7;
        protected long b = 8;

        public Test() {}
        public Test(int a) {this.a = a;}
        public Test(int a, long b) {this.a = a; this.b = b;}
        public int getA() {return a;}
        public long getB() {return b;}
        public void setA(int a) {this.a = a;}
    }

    public static void main(String[] args) {
        final Class<?> cls = Test.class;

        System.out.println("Class name: " + cls.getName());
        System.out.print("Modifiers: ");
        int mods = cls.getModifiers();
        if (Modifier.isPrivate(mods))
            System.out.print("private ");
        if (Modifier.isAbstract(mods))
            System.out.print("abstract ");
        if (Modifier.isStatic(mods))
            System.out.print("static ");
        if (Modifier.isFinal(mods))
            System.out.print("final ");

        System.out.println("\nPublic fields: ");
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            Class<?> fieldType = f.getType();
            System.out.println("\tName: " + f.getName());
            System.out.println("\ttype: " + f.getType());
        }

        System.out.println("All fields: ");
        fields = cls.getDeclaredFields();
        for (Field f : fields) {
            Class<?> fieldType = f.getType();
            System.out.println("\tName: " + f.getName());
            System.out.println("\tType: " + f.getType());
        }

        System.out.println("Constructors: ");
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor c : constructors) {
            Class<?>[] paramtypes = c.getParameterTypes();
            for (Class<?> paramType : paramtypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }

        try{
            Class<?>[] paramTypes = new Class<?>[] {int.class};
            Constructor<?> ctr = cls.getConstructor(paramTypes);
            Test t = (Test) ctr.newInstance(Integer.valueOf(1));
            System.out.println("Fields: " + t.getA() + ", " + t.getB());
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println("Name: " + method.getName());
            System.out.println("\tReturn type: " + method.getReturnType().getName());

            Class<?>[] paramTypes = method.getParameterTypes();
            System.out.print("\tParan types: ");
            for (Class<?> paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println();
        }

        try{
            Test obj = new Test();
            Class<?>[] paramTypes = new Class<?>[] {int.class};
            Method method = cls.getMethod("setA", paramTypes);
            Object[] arguments = new Object[] {Integer.valueOf(55)};
            method.invoke(obj, arguments);

            System.out.println("A: " + obj.getA());
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        try{
            Test obj = new Test();
            Class<?>[] paramTypes = new Class<?>[] {int.class};
            Method method = cls.getMethod("someUnknownMethod", paramTypes);
            Object[] arguments = new Object[] {Integer.valueOf(55)};
            method.invoke(obj, arguments);

            System.out.println("A: " + obj.getA());
        }catch (Exception ex) {
            System.out.println(ex.toString());
        }

        try {
            Test obj = new Test();
            Field field = cls.getDeclaredField("a");
            field.setAccessible(true);
            System.out.println("Private field value: " + field.getInt(obj));
            field.setInt(obj, 100);
            System.out.println("New private field value: " + field.getInt(obj));
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}