package org.spianmo.algorithm.SinglyLinkedList;

public class CountMaxNode {

    public static int countMaxNode(LinkList<Integer> list) {
        LinkNode<Integer> p = list.head;
        Integer maxValue = list.head.next.data;
        int count = 1;
        while (p.next != null) {
            System.out.println("=====Node=====>" + p.next.data);
            if (p.next.data > maxValue) {
                maxValue = p.next.data;
                count = 1;
            } else if (p.next.data.equals(maxValue)) {
                count++;
            }
            p = p.next;
        }
        System.out.println("===MaxValue===>" + maxValue);
        return count;
    }

    public static void testCountMaxNode1() {
        LinkList<Integer> linkList1 = new LinkList<>();
        linkList1.add(1);
        linkList1.add(2);
        linkList1.add(3);
        linkList1.add(3);
        linkList1.add(3);
        linkList1.add(4);
        System.out.println("================>最大值Node个数" + countMaxNode(linkList1));
    }

    public static void testCountMaxNode2() {
        LinkList<Integer> linkList2 = new LinkList<>();
        linkList2.addArray(new Integer[]{1, 2, 3, 4, 5, 5, 5});
        System.out.println("================>最大值Node个数" + countMaxNode(linkList2));
    }

    public static void testCountMaxNode3() {
        LinkList<Integer> linkList3 = new LinkList<>(new Integer[]{5, 5, 1, 5, 5, 5, 5, 3, 5, 5, 5});
        System.out.println("================>最大值Node个数" + countMaxNode(linkList3));
    }

}
