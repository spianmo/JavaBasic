package org.spianmo.learn.week10;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Finger
 * @Date 11/16/2020
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {
    private String name;
    private Integer age;

    @Override
    public int compareTo(Student o) {
        return this.age.compareTo(o.getAge());
    }
}
