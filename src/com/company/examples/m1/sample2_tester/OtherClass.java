package com.company.examples.m1.sample2_tester;

public class OtherClass {
    public static String work(String...ls) {
        StringBuilder sb = new StringBuilder();
        for (String s : ls)
            sb.append(s);

        return sb.toString();
    }

    @Test
    public static boolean testMethod() {
        boolean res = work("1", "22", "333").endsWith("122333");
        System.out.println("OtherClass: " + res);
        return res;
    }
}
