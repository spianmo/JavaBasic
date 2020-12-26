package org.spianmo.algorithm.Sort;

import java.util.Arrays;

/**
 * @ClassName SelectSort
 * @Description TODO
 * @Author Finger
 * @Date 12/15/2020
 **/
public class SelectSort {
    public static void selectionSort(int[] array) {
        int min;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(array, i, min);
            }
            System.out.println("==第"+(i+1)+"次==>"+Arrays.toString(array));
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int[] array = new int[]{75, 23, 98, 44, 57, 12, 29, 64, 38, 82};
        selectionSort(array);
        System.out.println("最终结果"+Arrays.toString(array));
    }
}
