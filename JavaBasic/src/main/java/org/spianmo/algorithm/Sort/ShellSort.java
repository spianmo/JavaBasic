package org.spianmo.algorithm.Sort;

import java.util.Arrays;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author Finger
 * @Date 12/15/2020
 **/
public class ShellSort {
    public static int[] shellSort(int[] array) {
        int d = array.length / 2;
        int tmp;
        while (d > 0) {
            for (int i = d; i < array.length; i++) {
                tmp = array[i];
                int j = i - d;
                while (j >= 0 && tmp < array[j]) {
                    array[j + d] = array[j];
                    j = j - d;
                }
                array[j + d] = tmp;
            }
            d = d / 2;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{75, 23, 98, 44, 57, 12, 29, 64, 38, 82};
        shellSort(array);
        System.out.println("最终结果"+ Arrays.toString(array));
    }
}
