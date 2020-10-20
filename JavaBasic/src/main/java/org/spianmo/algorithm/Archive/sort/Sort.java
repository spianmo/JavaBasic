package org.spianmo.algorithm.Archive.sort;

/**
 * @author Zhang Peng
 */
public interface Sort {

    /**
     * 排序接口
     *
     * @param list 要排序的数组
     */
    <T extends Comparable<T>> void sort(T[] list);

}
