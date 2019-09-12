package com.company.hw.m3_1.task2;

public class SomeClass {
    public static long doJob(long...ls) {
        long res = 0;
        for (long l : ls) {
            res += l;
        }

        return res;
    }

    @Test(value1 = 2, value2 = 5)
    public static boolean testMe(int a, int b) {
        return a + b == 7;
    }
}
