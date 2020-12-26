package org.spianmo.learn.week13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import lombok.SneakyThrows;

/**
 * @ClassName TimerTest
 * @Description TODO
 * @Author Finger
 * @Date 12/14/2020
 **/
public class ClockFrame extends JFrame {
    private JLabel timeLabel;
    private JPanel timePanel;
    private Runnable timerTask;
    public ClockFrame(){
        init();
        setTitle("闹钟窗口");
        setSize(new Dimension(600, 800));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
        timeLabel = new JLabel();
        timePanel = new JPanel(){
            @SneakyThrows
            @Override
            protected void paintComponent(Graphics g) {
                Image image = ImageIO.read(new File("D:\\Pictures\\1557135b60165933f2bhjvYU9.jpg"));
                g.drawImage(image,0,0,getWidth(),getHeight(),null);
            }
        };
        Font font = new Font("微软雅黑",Font.BOLD,20);
        timeLabel.setFont(font);
        timeLabel.setForeground(Color.WHITE);
        timePanel.setPreferredSize(new Dimension(600,800));
        timePanel.add(timeLabel);
        add(timePanel);
        timerTask = new Runnable(){
            @Override
            public void run() {
                String timeStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
                System.out.println(timeStr);
                timeLabel.setText(timeStr);
                if("2020-12-14 02:20:18".equals(timeStr)){
                    JOptionPane.showMessageDialog(timePanel,"第一个闹钟时间到了");
                }
                if("2020-12-14 02:46:18".equals(timeStr)){
                    JOptionPane.showMessageDialog(timePanel,"第二个闹钟时间到了");
                }
            }
        };
        ScheduledExecutorService mScheduledExecutorService = Executors.newScheduledThreadPool(4);
        mScheduledExecutorService.scheduleWithFixedDelay(timerTask, 1, 1, TimeUnit.SECONDS);

    }
    public static void main(String[] args) {
        new ClockFrame();
    }
}
