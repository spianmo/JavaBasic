package org.spianmo.learn.week2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Phone
 * @Description TODO
 * @Author Finger
 * @Date 10/12/2020
 **/

@AllArgsConstructor
@Getter
@ToString
@Setter
public class Phone {
    private String brand;
    private String model;
    private String number;
}
