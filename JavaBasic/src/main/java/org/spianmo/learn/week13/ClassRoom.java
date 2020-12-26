package org.spianmo.learn.week13;

/**
 * @ClassName ClassRoom
 * @Description TODO
 * @Author Finger
 * @Date 12/14/2020
 **/
public class ClassRoom implements Runnable{

    Thread teacher,student1,student2;

    public ClassRoom(){
        teacher = new Thread(this);
        student1 = new Thread(this);
        student2 = new Thread(this);
        teacher.setName("teacher");
        student1.setName("student1");
        student2.setName("student2");
    }
    @Override
    public void run() {
        if (Thread.currentThread() == teacher){
            for (int i = 1;i<=3;i++){
                System.out.println("上课");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) { }
            }
            student1.interrupt();
            if (!student1.isAlive()){
                student2.interrupt();
            }
        }else if (Thread.currentThread() == student1){
            System.out.println("student1正在睡觉");
            try {
                Thread.sleep(1000*60*10);
            } catch (InterruptedException e) {
                System.out.println("student1被吵醒");
            }
        }else if (Thread.currentThread() == student2){
            System.out.println("student2正在睡觉");
            try {
                Thread.sleep(1000*60*60);
            } catch (InterruptedException e) {
                System.out.println("student2被老师叫醒了");
            }
        }
    }

    public static void main(String[] args) {
        ClassRoom room = new ClassRoom();
        room.student1.start();
        room.student2.start();
        room.teacher.start();
    }
}
