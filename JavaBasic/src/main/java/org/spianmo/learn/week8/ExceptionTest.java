package org.spianmo.learn.week8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @ClassName testException
 * @Description TODO
 * @Author Finger
 * @Date 11/2/2020
 **/
public class ExceptionTest {
    public static void main(String[] args) {
        int result = 0;
        try {
            result = 3 / 0;
        } catch (ArithmeticException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("除数不能为零");
            e.printStackTrace();
        }
        System.out.println(result);

        int[] intArrays = new int[]{1, 2, 3, 4, 5};
        try {
            int tmp = intArrays[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界，越界数组索引号为" + e.getMessage());
            System.out.println("越界原因：" + e.getCause());
            System.out.println("异常的详细信息：" + e.getMessage());
            System.out.println("异常对象e：" + e.toString());
            e.printStackTrace();
        }

        System.out.println("请输入价格");
        Scanner scanner = new Scanner(System.in);
        String priceStr = scanner.nextLine();
        int price = 0;
        try {
            price = Integer.parseInt(priceStr);
        }catch (NumberFormatException e){
            System.out.println("数字格式化异常"+e.getMessage());
        }
        System.out.println("price = " + price);

        File file = new File("sasasas");
        try {
            InputStream is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("文件没找到"+e.getMessage());
            e.printStackTrace();
        }
    }

}
