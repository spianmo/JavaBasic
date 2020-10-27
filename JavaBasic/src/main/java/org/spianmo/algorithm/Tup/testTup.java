package org.spianmo.algorithm.Tup;

/**
 * @ClassName testTup
 * @Description TODO
 * @Author Finger
 * @Date 10/27/2020
 **/
public class testTup {
    public static void main(String[] args) {
        TupClass tup = new TupClass();
        int[][] input = new int[][]{
                {0, 1, 0, 5}, {0, 2, 5, 1}, {6, 0, 0, 0}
        };
        tup.createTup(input, 3, 4);

        System.out.println("========>值为"+tup.getValue(1, 3));
        tup.display();
    }
}
