package org.spianmo.learn.week10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName MapTest
 * @Description TODO
 * @Author Finger
 * @Date 11/16/2020
 **/
public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 12);
        map.put("pear", 8);
        map.put("banana", 24);
        System.out.println(map);

        System.out.println("增强for循环遍历Map");
        for (String key : map.keySet()) {
            System.out.println("键===>" + key + " 值===>" + map.get(key));
        }

        System.out.println("迭代器遍历Map");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("键===>" + entry.getKey() + " 值===>" + entry.getValue());
        }

        System.out.println("遍历Map的Value集合");
        for (Integer integer : map.values()) {
            System.out.println("值===>" + integer);
        }

        System.out.println("通过遍历Entry遍历Map");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("键===>" + entry.getKey() + " 值===>" + entry.getValue());
        }

        System.out.println("Lambda表达式遍历Map");
        map.forEach((key, value) -> System.out.println("键===>" + key + " ===>值" + value));
    }
}
