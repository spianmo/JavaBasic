package org.spianmo.learn.week4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import lombok.val;

/**
 * @ClassName test
 * @Description TODO
 * @Author Finger
 * @Date 10/19/2020
 **/
public class test {
    public static void main(String[] args) throws InterruptedException, ParseException {
        Random random = new Random();
        int[][] data = new int[2][2];
        for(int[] tmp : data){
            tmp[0] = random.nextInt(2000000);
            tmp[1] = random.nextInt(2000000);
            System.out.println(OverLoadTest.sum(tmp[0], tmp[1]));
        }


        System.out.println(System.currentTimeMillis());
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("现在的时间戳："+end);
        System.out.println("两个时间戳的差值："+(end-start));
        System.out.println("经过了"+(double)(end-start)/1000+"秒");
        //SimpleDateFormat sdf1 = new SimpleDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        System.out.println(sdf.format(new Date()));
        long unkown = sdf.parse("2020-10-29 15:40:20+0000").getTime();
        System.out.println("一个未知的时间戳："+unkown);
    }
}
