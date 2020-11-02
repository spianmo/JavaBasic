package org.spianmo.learn.week8;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Book
 * @Description TODO
 * @Author Finger
 * @Date 11/2/2020
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    @NotNull(message = "书名不能为空")
    private String name;
    private BigDecimal price;
    @NotNull(message = "ISBN不能为空")
    private String isbn;
}
