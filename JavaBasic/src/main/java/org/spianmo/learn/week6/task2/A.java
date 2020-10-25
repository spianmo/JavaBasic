package org.spianmo.learn.week6.task2;

/**
 * @ClassName A
 * @Description TODO
 * @Author Finger
 * @Date 10/25/2020
 **/
public class A {
    public int f(int a, int b) {
        if (b < a) {
            int temp = 0;
            temp = a;
            a = b;
            b = temp;
        }
        int r = b % a;
        while (r != 0) {
            b = a;
            a = r;
            r = b % a;
        }
        return a;
    }
}

