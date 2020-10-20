package org.spianmo.algorithm.Stack;

import java.util.Random;

/**
 * @ClassName testStack
 * @Description TODO
 * @Author Finger
 * @Date 10/20/2020
 **/
public class testStack {
    public static void main(String[] args) {
        /**
         * ArrayBaseStack 基于数组的Stack实现，push、pop自动扩缩等等
         */
        ArrayBaseStack<Integer> arrayBaseStack = new ArrayBaseStack<>();
        Random random = new Random();
        for (int i = 0; i < arrayBaseStack.INITCAPACITY; i++){
            arrayBaseStack.push(random.nextInt(100));
        }
        System.out.println("==================>栈内部："+ arrayBaseStack);
        arrayBaseStack.push(1);
        arrayBaseStack.push(2);
        arrayBaseStack.push(3);
        arrayBaseStack.push(4);
        arrayBaseStack.push(5);
        Integer popInteger = arrayBaseStack.pop();
        System.out.println("==================>出栈元素为："+ popInteger + " 此时栈顶指针为："+ arrayBaseStack.getTopPtr());
        System.out.println("==================>栈内部："+ arrayBaseStack);

        System.out.println("#################################################################");
        /**
         * LinkedStack 基于链表的Stack实现
         */
        LinkedBaseStack<Integer> linkedBaseStack = new LinkedBaseStack<>();
        for (int i = 0; i < 10; i++){
            linkedBaseStack.push(random.nextInt(100));
        }
        System.out.println("==================>栈内部："+ linkedBaseStack);
        linkedBaseStack.push(1);
        linkedBaseStack.push(2);
        linkedBaseStack.push(3);
        linkedBaseStack.push(4);
        linkedBaseStack.push(5);
        Integer popInteger2 = linkedBaseStack.pop();
        System.out.println("==================>出栈元素为："+ popInteger2);
        System.out.println("==================>栈内部："+ linkedBaseStack);

    }
}
