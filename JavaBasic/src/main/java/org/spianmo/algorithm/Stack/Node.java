package org.spianmo.algorithm.Stack;

/**
 * @ClassName Node
 * @Description TODO
 * @Author Finger
 * @Date 10/20/2020
 **/
public class Node<E> {

    public E data;
    public Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

}