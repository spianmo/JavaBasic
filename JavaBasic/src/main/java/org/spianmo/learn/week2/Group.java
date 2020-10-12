package org.spianmo.learn.week2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Group
 * @Description TODO
 * @Author Finger
 * @Date 10/12/2020
 **/

@AllArgsConstructor
@Setter
@Getter
public class Group {
    private String groupId;
    private Student[] student;
}
