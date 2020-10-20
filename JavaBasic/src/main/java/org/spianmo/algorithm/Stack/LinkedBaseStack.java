package org.spianmo.algorithm.Stack;

/**
 * @ClassName LinkedStack
 * @Description TODO
 * @Author Finger
 * @Date 10/20/2020
 **/
public class LinkedBaseStack<E> {

    private int size = 0;
    private Node<E> top = null;

    public void push(E value) {
        Node<E> node = new Node<>(value, null);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        size++;
    }

    public E pop() {
        if (top == null) {
            return null;
        }
        E val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public E peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> p = top;
        while (p != null) {
            sb.append(p.data);
            sb.append(" ");
            p = p.next;
        }
        return sb.toString();
    }
}

