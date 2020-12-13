package org.spianmo.algorithm.Search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName BinarySearch
 * @Description TODO
 * @Author Finger
 * @Date 11/26/2020
 **/
public class BinarySearch {
    public static int find(int[] array, int value) {
        int min = 0;
        int max = array.length - 1;
        int mid = (min + max) / 2;

        while(array[mid] != value) {
            if(array[mid] < value) {
                min = mid + 1;
            }else if (array[mid] > value){
                max = mid - 1;
            }

            mid = (min + max) / 2;
            if(min > max) {
                return -1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Scanner scanner = new Scanner(System.in);
        int findValue = Integer.parseInt(scanner.next());
        System.out.println("待查找数组为"+ Arrays.toString(array));
        System.out.println("待查找值为"+findValue);
        System.out.println("查找的index为"+find(array,findValue));
    }
}
