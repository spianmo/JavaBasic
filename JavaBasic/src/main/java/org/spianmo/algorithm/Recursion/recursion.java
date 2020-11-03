package org.spianmo.algorithm.Recursion;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName recursion
 * @Description TODO
 * @Author Finger
 * @Date 10/27/2020
 **/
public class recursion {
    public final static int MAXCAPACITY = 10;

    public static int getMinRecursion(int[] arr, int index) {
        return index == 0 ? arr[0] : Math.min(arr[index], getMinRecursion(arr, index - 1));
    }

    public static int getMaxRecursion(int[] arr, int index) {
        return index == 0 ? arr[0] : Math.max(arr[index], getMaxRecursion(arr, index - 1));
    }

    public static int getMaxRecursion(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = (L + R) / 2;
        int maxLeft = getMaxRecursion(arr, L, mid);
        int maxRight = getMaxRecursion(arr, mid + 1, R);
        return Math.max(maxLeft, maxRight);
    }

    public static int getMinRecursion(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = (L + R) >> 1;
        int minLeft = getMinRecursion(arr, L, mid);
        int minRight = getMinRecursion(arr, mid + 1, R);
        return Math.min(minLeft, minRight);
    }

    public static void  fun(int n){
        if (n==1){
            System.out.println("a:1");
        }else{
            System.out.println("b:"+n);
            fun(n-1);
            System.out.println("c:"+n);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[MAXCAPACITY];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("============>随机数组为" + Arrays.toString(array));
        System.out.println("============>尾递归求最小值为" + getMinRecursion(array, array.length - 1));
        System.out.println("============>尾递归求最大值为" + getMaxRecursion(array, array.length - 1));
        System.out.println("============>双递归优化最小值为" + getMinRecursion(array, 0, array.length - 1));
        System.out.println("============>双递归优化最大值为" + getMaxRecursion(array, 0, array.length - 1));
        fun(5);
    }
}
