package org.spianmo.learn.week7;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName MarketEmployee
 * @Description TODO
 * @Author Finger
 * @Date 10/26/2020
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MarketEmployee extends BaseEmployee{

    private String id;
    private static final String ADMIN = "admin";
    private static int HIGHER_SALARY = 3000;
    private static int LOWER_SALARY = 1000;

    @Override
    public void print() {
        super.print();
        System.out.println("This is a MarketEmployee class");
    }

    @Override
    public int getSalary() {
        if (ADMIN.equals(this.id)){
            return HIGHER_SALARY;
        }else{
            return LOWER_SALARY;
        }
    }
}
