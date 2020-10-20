package org.spianmo.algorithm.Archive.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists">203. 移除链表元素</a>
 * @since 2020-06-09
 */
public class 移除链表元素 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2);
        System.out.println(ListUtil.toList(head));
        ListNode result = removeElementByValue(head, 1);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 2 }, list.toArray(new Integer[0]));

        head = new ListNode(1);
        System.out.println(ListUtil.toList(head));
        result = removeElementByValue(head, 1);
        list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] {}, list.toArray(new Integer[0]));

        head = ListUtil.buildList(1, 1);
        System.out.println(ListUtil.toList(head));
        result = removeElementByValue(head, 1);
        list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] {}, list.toArray(new Integer[0]));

        head = ListUtil.buildList(1, 2, 6, 3, 4, 5, 6);
        System.out.println(ListUtil.toList(head));
        result = removeElementByValue(head, 6);
        list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, list.toArray(new Integer[0]));
    }

    public static ListNode removeElementByValue(ListNode head, int val) {
        if (head == null) return null;

        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode prev = root;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return root.next;
    }

    public static ListNode removeElementByIndex(ListNode head, int index) {
        if (head == null) {
            return null;
        }

        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode node = root;
        int pos = 0;
        while (node.next != null && pos != index) {
            node = node.next;
            pos++;
        }

        if (node.next != null) {
            node.next = node.next.next;
        }

        return root.next;
    }

}
