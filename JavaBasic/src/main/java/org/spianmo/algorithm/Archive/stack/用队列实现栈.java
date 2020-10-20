package org.spianmo.algorithm.Archive.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于队列实现的栈
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/implement-stack-using-queues/">225. 用队列实现栈</a>
 * @since 2020-01-18
 */
public class 用队列实现栈<T> {

    public static void main(String[] args) {
        用队列实现栈<Integer> stack = new 用队列实现栈<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private Queue<T> q1 = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public 用队列实现栈() { }

    /**
     * Push element x onto stack.
     */
    public void push(T x) {
        q1.add(x);
        int sz = q1.size();
        while (sz > 1) {
            q1.add(q1.remove());
            sz--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public T pop() {
        return q1.poll();
    }

    /**
     * Get the top element.
     */
    public T top() {
        return q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }

}
