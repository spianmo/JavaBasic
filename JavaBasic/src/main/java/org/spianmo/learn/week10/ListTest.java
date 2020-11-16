package org.spianmo.learn.week10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @ClassName ListTest
 * @Description TODO
 * @Author Finger
 * @Date 11/16/2020
 **/
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C++");
        list.add("Java");

        Random random = new Random();
        String result = list.get(random.nextInt(list.size()));
        System.out.println(result);

        System.out.println("增强for循环遍历集合");
        for (String str : list) {
            System.out.println("============>" + str);
        }

        System.out.println("迭代器遍历集合");
        Iterator<String> iterable = list.iterator();
        while (iterable.hasNext()) {
            System.out.println("=============>" + iterable.next());
        }

        System.out.println("Lambda表达式遍历集合");
        list.forEach(str -> System.out.println("==============>"+str));
        list.forEach(System.out::println);
    }
}
