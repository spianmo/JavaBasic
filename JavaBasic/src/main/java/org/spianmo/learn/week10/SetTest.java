package org.spianmo.learn.week10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName SetTest
 * @Description TODO
 * @Author Finger
 * @Date 11/16/2020
 **/
public class SetTest {
    public static void main(String[] args) {
        //Set<String> set = new TreeSet<>();
        Set<String> set = new HashSet<>();
        set.add("C");
        set.add("A");
        set.add("B");
        System.out.println("增强for循环遍历集合");
        for (String str : set) {
            System.out.println("============>" + str);
        }

        System.out.println("迭代器遍历集合");
        Iterator<String> iterable = set.iterator();
        while (iterable.hasNext()) {
            System.out.println("=============>" + iterable.next());
        }

        System.out.println("Lambda表达式遍历集合");
        set.forEach(str -> System.out.println("==============>"+str));
        set.forEach(System.out::println);

        Set<Student> studentSet = new TreeSet<>();
        studentSet.add(new Student("唐钱进",21));
        studentSet.add(new Student("余欣婷",20));
        studentSet.forEach(System.out::println);
    }
}
