package org.spianmo.learn.week6.task2;

/**
 * @ClassName test
 * @Description TODO
 * @Author Finger
 * @Date 10/25/2020
 **/
public class test {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("最大公约数 ：" + a.f(36, 24));
        a = new B();
        System.out.println("最小公倍数 ：" + a.f(36, 24));
    }

}
