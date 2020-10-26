package org.spianmo.learn.week7;

/**
 * @ClassName BaseEmployee
 * @Description TODO
 * @Author Finger
 * @Date 10/26/2020
 **/
public abstract class BaseEmployee {
    public void print(){
        System.out.println("This is a BaseEmployee class");
    }

    /**
     * 根据员工ID获取具体薪水
     *
     * @return int 薪水
     */
    public abstract int getSalary();
}
