package org.spianmo.algorithm.SinglyLinkedList;


/**
 * @author Finger
 * @file IntegerLinkList.java
 * @CopyRight (C) https://spianmo.com
 * @brief
 * @email Finger@spianmo.com
 * @date 2020/10/01
 */
public class IntegerLinkList extends LinkList<Integer> {

    private java.lang.Integer max;
    private java.lang.Integer min;

    public IntegerLinkList() {
        super();
    }

    public IntegerLinkList(Integer[] array) {
        if (array == null || array.length == 0){
            return;
        }
        max = array[0];
        min = array[0];
        addArraySafe(array, node -> {
            max = node < max ? max : node;
            min = node > min ? min : node;
        }, java.lang.Integer.class);
    }

    public java.lang.Integer maxValue() {
        return max;
    }

    public java.lang.Integer minValue() {
        return min;
    }
}
