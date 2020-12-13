package org.spianmo.learn.week12;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SaleRunnable
 * @Description TODO
 * @Author Finger
 * @Date 12/7/2020
 **/
public class SaleRunnable implements Runnable {

    @Override
    public void run() {
        while (true) {
            synchronized (this){
                if (tickets > 0) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("--"+Thread.currentThread().getName() + "售出了第" + (tickets--) + "张票");
                } else {
                    System.out.println("--"+Thread.currentThread().getName()+"余票不足，停止售票");
                    break;
                }
            }
        }

    }

    public static int THREAD_NUM = 3;
    public static int tickets = 10;

    public static void main(String[] args) {
        SaleRunnable saleRunnable = new SaleRunnable();
        List<Thread> list = new ArrayList<>();
        for (int i = 1; i <= THREAD_NUM; i++) {
            list.add(new Thread(saleRunnable,"窗口" + i));
        }
        list.forEach(Thread::start);
    }
}
