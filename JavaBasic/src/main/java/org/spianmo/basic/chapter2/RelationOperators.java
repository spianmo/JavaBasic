package org.spianmo.basic.chapter2;

/**
 * Created by beigui on 2016/1/28.
 * 功能：关系运算符
 */
public class RelationOperators {
    public static void main(String[] args) {
        Integer a = 130;
        Integer b = 130;
        if (a.equals(b)) {
            System.out.println("a equals b");
        }
        b--;
        if (a > b) {
            System.out.println("a > b");
        }

        if (a < b) {
            System.out.println("a < b");
        }
    }
}
