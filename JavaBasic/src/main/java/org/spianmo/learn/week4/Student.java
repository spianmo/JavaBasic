package org.spianmo.learn.week4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Finger
 * @Date 10/19/2020
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {

    private String name;
    private String id;

    public Student(String name) {
        super(name);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    /**
     * Override重写父类的sayName方法
     */
    @Override
    public void sayName() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name=");
        sb.append(name);
        System.out.println(sb.toString());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * OverLoad重载与返回值类型无关，只看参数列表（参数的个数、参数的类型、参数的顺序）
     */
    public void eat() {

    }

    public void eat(String foodName,int i) {

    }

    public void eat(String foodName) {

    }
}
