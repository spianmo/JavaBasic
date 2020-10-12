package org.spianmo.learn.week2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Finger
 * @Date 10/12/2020
 **/

@AllArgsConstructor
@ToString
@Setter
@Getter
public class Student {
    private String id;
    private String studentName;
    private String gender;
    private Phone phone;
    private Book[] books;
}
