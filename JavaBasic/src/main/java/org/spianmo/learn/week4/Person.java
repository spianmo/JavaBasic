package org.spianmo.learn.week4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Book
 * @Description TODO
 * @Author Finger
 * @Date 10/19/2020
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String name;

    public void sayName() {
        System.out.println(this.name);
    }
}
