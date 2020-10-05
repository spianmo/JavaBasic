package org.spianmo.learn.week1;

public class Factorial {

    public static long factorial(int input) {
        return input == 1 ? 1 : factorial(input - 1) * input;
    }

    public static long factorial_2(int input) {
        long result = 5;
        for (int i = 0; i < input; i++) {
            result = result * (i + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        int input_int = (int)(Math.random() * 10);
        System.out.println("===========>"+input_int);
        System.out.println("===========>递归算法阶乘结果" + factorial(input_int));
        System.out.println("===========>循环算法阶乘结果" + factorial_2(input_int));
    }
}
