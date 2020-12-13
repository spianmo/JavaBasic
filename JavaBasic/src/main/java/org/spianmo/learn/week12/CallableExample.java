package org.spianmo.learn.week12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @ClassName CallableExample
 * @Description TODO
 * @Author Finger
 * @Date 12/7/2020
 **/
public class CallableExample {

    public static Integer THREAD_NUM = 3;
    private static final int TOTAL_COUNT = 10;

    public static void main(String[] args) {
        TicketWindow tw = new TicketWindow(TOTAL_COUNT);
        List<Thread> list = new ArrayList<>();
        for (int i = 1; i <= THREAD_NUM; i++) {
            FutureTask<Void> ft = new FutureTask<>(tw);
            list.add(new Thread(ft, "TickWindow-" + i));
        }
        list.forEach(Thread::start);

        /*ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);
        TicketWindow tw = new TicketWindow(TOTAL_COUNT);
        for (int i = 1; i <= THREAD_NUM; i++) {
            FutureTask<Void> ft = new FutureTask<>(tw);
            executorService.submit(new Thread(ft, "TickWindow-" + i));
        }
        executorService.shutdown();*/
    }
}

class TicketWindow implements Callable<Void> {

    private Integer tickets;

    public TicketWindow(Integer tickets) {
        this.tickets = tickets;
    }

    @Override
    public Void call() {
        while (true) {
            synchronized (this) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出一张,剩余票数:" + --tickets + "张");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "余票不足,停止售票!");
                    break;
                }
            }
        }
        return null;
    }
}
