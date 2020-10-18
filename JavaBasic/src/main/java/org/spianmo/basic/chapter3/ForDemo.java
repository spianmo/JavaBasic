package org.spianmo.basic.chapter3;

/**
 * Created by beigui on 2016/1/30.
 * 功能：从1加到100的和
 */
public class ForDemo {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <100;i++){
            sum = sum + i;
        }
        System.out.println(sum);
    }
}
