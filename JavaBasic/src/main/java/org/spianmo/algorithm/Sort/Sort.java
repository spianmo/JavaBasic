package org.spianmo.algorithm.Sort;

import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author Finger
 * @Date 12/8/2020
 **/
public class Sort {

    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

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

    public static int[] binInsertSort(int[] array) {
        int low, high, mid;
        int tmp;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                tmp = array[i];
                low = 0;
                high = i - 1;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (tmp < array[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                for (int j = i - 1; j >= high + 1; j--) {
                    array[j + 1] = array[j];
                }
                array[high + 1] = tmp;
            }
        }
        return array;
    }
    public static void BubbleSort(int[] arr) {
        boolean flag = true;
        while(flag){
            int temp;//定义一个临时变量
            for(int i=0;i<arr.length-1;i++){//冒泡趟数，n-1趟
                for(int j=0;j<arr.length-i-1;j++){
                    if(arr[j+1]<arr[j]){
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        flag = true;
                    }
                }
                if(!flag){
                    break;//若果没有发生交换，则退出循环
                }
            }
        }
    }

    public static int[] bubbleSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("=======>"+Arrays.toString(array));
        }
        return array;
    }


    public static void main(String[] args) {
        int[] array = new int[]{75,23,98,44,57,12,29,64,38,82};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }
}
