package org.spianmo.learn.week6.task2;

/**
 * @ClassName b
 * @Description TODO
 * @Author Finger
 * @Date 10/25/2020
 **/
public class B extends A {
    @Override
    public int f(int a, int b) {
        int division = super.f(a, b);
        return (a * b) / division;
    }
}

