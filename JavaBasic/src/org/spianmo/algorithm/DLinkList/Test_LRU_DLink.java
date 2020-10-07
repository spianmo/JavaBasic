package org.spianmo.algorithm.DLinkList;

/**
 * @ClassName LRUDLinkTest
 * @Description TODO
 * @Author Finger
 * @Date 10/7/2020
 **/
public class Test_LRU_DLink {
    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 5, 6};
        DLinkList<Integer> list = new DLinkList<>(input);
        System.out.println(list);
        list.find(4);
        list.find(6);
        list.find(4);
        list.find(4);
        list.find(4);
        System.out.println(list);
    }
}
