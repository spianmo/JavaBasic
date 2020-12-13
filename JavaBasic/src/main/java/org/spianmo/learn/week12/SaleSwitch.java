package org.spianmo.learn.week12;

/**
 * @ClassName SaleSwitch
 * @Description TODO
 * @Author Finger
 * @Date 12/7/2020
 **/
public class SaleSwitch {
    public static void main(String[] args) {
        for(int i=1 ; i<4; i++){
            new SaleThread("[00"+i+"]").start();
        }
    }
}

class SaleThread extends Thread {

    private static int ticket = 20;

    private static Object obj = new Object();

    public SaleThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "号窗口第" + ticket + "票正在出票...");
                    ticket--;
                } else {
                    System.out.println("车票已售完，下次请趁早...");
                    System.exit(0);
                }
            }
        }
    }
}
