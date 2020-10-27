package org.spianmo.algorithm.Tup;

import java.util.ArrayList;

/**
 * @ClassName TupClass
 * @Description TODO
 * @Author Finger
 * @Date 10/27/2020
 **/
public class TupClass {
    int rows;
    int cols;
    int count;
    ArrayList<TupElem> data;

    public TupClass() {
        this.data = new ArrayList<>();
        count = 0;
        int[] test = new int[]{1,2,3};
        int test1 = test[1];
    }

    public void createTup(int[][] data, int m, int n) {
        rows = m;
        cols = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] != 0) {
                    this.data.add(new TupElem(i, j, data[i][j]));
                    count++;
                }
            }
        }
    }

    public boolean setValue(int i, int j, int x) {
        int k = 0;
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        while (k < count && i > data.get(k).row) {
            k++;
        }
        while (k < count && i == data.get(k).row && j > data.get(k).col) {
            k++;
        }
        if (data.get(k).row == i && data.get(k).col == j) {
            data.set(k, new TupElem(i, j, x));
        } else {
            data.add(k, new TupElem(i, j, x));
            count++;
        }
        return true;
    }


    public int getValue(int i, int j) {
        int k = 0;
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return 0;
        }
        while (k < count && data.get(k).row < i) {
            k++;
        }
        while (k < count && data.get(k).row == i && data.get(k).col < j) {
            k++;
        }
        if (data.get(k).row == i && data.get(k).col == j) {
            return data.get(k).value;
        }
        return 0;
    }

    public void display() {
        if (count <= 0) {
            return;
        }
        System.out.printf("行数=%d, 列数=%d, 非0元素个数=%d\n", rows, cols, count);
        for (int i = 0; i < count; i++) {
            System.out.printf("%5d%5d%5d\n", data.get(i).row, data.get(i).col, data.get(i).value);
        }
    }
}
