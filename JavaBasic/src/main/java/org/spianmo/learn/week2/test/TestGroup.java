package org.spianmo.learn.week2.test;

import org.spianmo.learn.week2.Book;
import org.spianmo.learn.week2.Group;
import org.spianmo.learn.week2.Phone;
import org.spianmo.learn.week2.Student;

import java.math.BigDecimal;

/**
 * @ClassName TestGroup
 * @Description TODO
 * @Author Finger
 * @Date 10/12/2020
 **/
public class TestGroup {
    public static void main(String[] args) {
        Book book1 = new Book("老人与海", "ISBN-1000-2222-4444", "海明威", new BigDecimal("24.00"), new java.util.Date());
        Student student1 = new Student("001", "唐钱进", "男", new Phone("小米", "小米10", "13861948872"), new Book[]{book1});
        Student student2 = new Student("002", "余欣婷", "女", new Phone("华为", "Nova2S", "18854583778"), new Book[]{book1});
        Student student3 = new Student("003", "杨文涛", "男", new Phone("苹果", "苹果8", "132432435543"), new Book[]{book1});
        Student student4 = new Student("004", "付洁", "女", new Phone("Vivo", "Findx", "173247423232"), new Book[]{book1});
        Group group1 = new Group("001", new Student[]{student1, student2, student3, student4});
        for (Student student : group1.getStudent()) {
            System.out.println(student.toString());
        }
    }
}
