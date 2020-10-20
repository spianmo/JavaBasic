package org.spianmo.algorithm.Stack;

import java.util.Arrays;

/**
 * @ClassName Stack
 * @Description TODO
 * @Author Finger
 * @Date 10/20/2020
 **/
public class ArrayBaseStack<E> {

    final int INITCAPACITY = 10;
    private int capacity;
    private E[] data;
    private int top;

    public ArrayBaseStack() {
        data = (E[]) new Object[INITCAPACITY];
        capacity = INITCAPACITY;
        top = -1;
    }

    public void push(E e) {
        if (top == capacity - 1) {
            System.out.println("触发扩容，原先容量 " + capacity + "当前容量 " + 2 * capacity);
            updateCapacity(2 * capacity);
        } else {
            top++;
        }
        System.out.println("入栈 "+"E["+ top +"]"+"入栈元素===>"+e);
        data[top] = e;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("栈空");
        }
        E e = data[top];
        data[top] = null;
        top--;
        if (top + 1 > INITCAPACITY && top + 1 == capacity / 4) {
            System.out.println("触发堆缩，原先容量 "+ capacity + "当前容量 " + 2 * capacity);
            updateCapacity(capacity / 2);
        }
        System.out.println("出栈 "+"E["+ top +"]"+"出栈元素===>"+e);
        return e;
    }

    public int getTopPtr() {
        return top;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("栈空");
        }
        return data[top];
    }

    public void updateCapacity(int cap) {
        E[] newData = (E[]) new Object[cap];
        for (int i = 0; i < top; i++) {
            newData[i] = data[i];
        }
        capacity = cap;
        data = newData;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}

