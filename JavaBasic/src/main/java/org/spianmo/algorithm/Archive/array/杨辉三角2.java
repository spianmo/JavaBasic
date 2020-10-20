package org.spianmo.algorithm.Archive.array;


import org.spianmo.algorithm.Archive.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//    【杨辉三角 II】
//
//    给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//
//    在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//    示例:
//
//    输入: 3
//    输出: [1,3,3,1]
//    进阶：
//
//    你可以优化你的算法到 O(k) 空间复杂度吗？

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class 杨辉三角2 {

    public static void main(String[] args) {
        List<Integer> list = 杨辉三角2.getRow(3);
        System.out.println(ArrayUtil.getArrayString(list.toArray(), 0, list.size() - 1));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        int rows = rowIndex + 1;
        if (rows <= 0) {

        } else if (rows == 1) {
            result.add(Arrays.asList(1));
        } else if (rows == 2) {
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1, 1));
        } else {
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1, 1));
            for (int i = 2; i < rows; i++) {
                List<Integer> current = result.get(i - 1);
                List<Integer> next = new ArrayList<>();

                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        next.add(1);
                    } else {
                        int x = current.get(j - 1);
                        int y = current.get(j);
                        next.add(x + y);
                    }
                }

                result.add(next);
            }
        }

        return result.get(rowIndex);
    }

}
