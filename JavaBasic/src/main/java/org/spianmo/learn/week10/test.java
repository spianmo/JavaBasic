package org.spianmo.learn.week10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName test
 * @Description TODO
 * @Author Finger
 * @Date 11/16/2020
 **/
public class test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Tom", "CoreJava");
        map.put("John", "Oracle");
        map.put("Susan", "Oracle");
        map.put("Jerry", "JDBC");
        map.put("Jim", "Unix");
        map.put("Kevin", "JSP");
        map.put("Lucy", "JSP");

        //增加一位新老师Allen教JDBC;
        map.put("Allen", "JDBC");

        //Lucy改为教CoreJava
        map.replace("Lucy", "CoreJava");

        //至少使用两种方式遍历Map
        System.out.println("=========================遍历Entry遍历Map=========================");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("老师===>" + entry.getKey() + " 教===>" + entry.getValue());
        }
        System.out.println("=========================Lambda表达式遍历Map=========================");
        map.forEach((key, value) -> System.out.println("老师===>" + key + " 教===>" + value));

        ArrayList<String> result = new ArrayList<>();
        //输出所有教JDBC的讲师
        map.forEach((key, value) -> {
            if ("JDBC".equals(value)) {
                result.add(key);
            }
        });
        System.out.println("foreach筛选所有教JDBC的老师为" + result);

        ArrayList<String> result1 = new ArrayList<>();
        map.entrySet().stream().filter(entry -> "JDBC".equals(entry.getValue())).forEach(entry -> {
            result1.add(entry.getKey());
        });
        System.out.println("stream api配合filter筛选所有教JDBC的老师为" + result1);
    }
}
