package org.spianmo.learn.week12;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SaleTicketThread
 * @Description TODO
 * @Author Finger
 * @Date 12/7/2020
 **/
public class SaleTicketThread extends Thread {

    public SaleTicketThread(String name) {
        super(name);
    }

    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("--"+Thread.currentThread().getName()+"正在卖出第"+tickets+"张票");
                    --tickets;
                } else {
                    System.out.println("--"+Thread.currentThread().getName()+"余票不足，停止售票");
                    break;
                }
            }
        }
    }

    public static int tickets = 10;
    public static int THREAD_NUM = 3;

    public static void main(String[] args) {
        List<SaleTicketThread> list = new ArrayList<>();
        for (int i = 1; i <= THREAD_NUM; i++) {
            list.add(new SaleTicketThread("窗口" + i));
        }
        list.forEach(Thread::start);
    }

}

