package org.spianmo.algorithm.SinglyLinkedList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemove {

    public static Integer[] duplicateRemoveFun1(Integer[] array) {
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, array);
        Integer[] array_s = new Integer[set.size()];
        set.toArray(array_s);
        return array_s;
    }

    public static int[] duplicateRemoveFun2(int[] array) {
        int[] newArr = new int[array.length];
        int index = 0;
        outer:
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    continue outer;
                }
            }
            newArr[index] = array[i];
            index++;
        }
        int[] result = new int[index];
        if (index >= 0) System.arraycopy(newArr, 0, result, 0, index);
        return result;
    }

    public static int[] duplicateRemoveFun3(int[] array) {
        int i = 0, j;
        for (j = 1; j < array.length; j++) {
            if (array[i] != array[j]) {
                i++;
                array[i] = array[j];
            }
        }
        int[] newArr = new int[i+1];
        System.arraycopy(array,0,newArr,0,i+1);
        return newArr;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] arrayObj = new Integer[]{1, 1, 2, 2, 2};
        int[] array = new int[]{1, 1, 2, 2, 2};
        System.out.println(Arrays.toString(duplicateRemoveFun1(arrayObj)));
        System.out.println(Arrays.toString(duplicateRemoveFun2(array)));
        System.out.println(Arrays.toString(duplicateRemoveFun3(array)));
    }
}
