package org.spianmo.algorithm.SinglyLinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class Factorial {

    public static long factorial(int input) {
        return input == 1 ? 1 : factorial(input - 1) * input;
    }

    public static long factorial_2(int input) {
        long result = 1;
        for (int i = 0; i < input; i++) {
            result = result * (i + 1);
        }
        return result;
    }
    

    public static void main(String[] args) {
        String input_int;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("===========>输入阶乘底数,输入exit退出");
            input_int = scanner.next();
            if (input_int.equals("exit")){
                break;
            }
            System.out.println("===========>递归算法阶乘结果"+factorial(Integer.parseInt(input_int)));
            System.out.println("===========>循环算法阶乘结果"+factorial_2(Integer.parseInt(input_int)));
        }
    }
}
