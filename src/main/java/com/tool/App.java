package com.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App implements Runnable
{
    private Robot robot;
    private boolean isStop = false;

    public App(){
        try {
            CotrollerFrame frame = new CotrollerFrame("Prevent Locking");
            frame.setVisible(true);
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        int x;
        int y;
        Random random = new Random();
        while(!isStop){
            Point mousepoint = MouseInfo.getPointerInfo().getLocation();
            //随机生成坐标
            //x = random.nextInt(1000);
            //y = random.nextInt(1000);
            //开始移动
            robot.mouseMove(mousepoint.x+1,mousepoint.y);
            robot.mouseMove(mousepoint.x-1,mousepoint.y);
            //每5秒跑一次
            robot.delay(59000);
        }
    }
    //
    private class CotrollerFrame extends JFrame {
        private static final long serialVersionUID = 1L;

        private JButton close = new JButton("关闭");
        public CotrollerFrame(String title){
            this();
            setTitle(title);
        }
        //
        public CotrollerFrame(){
            setLayout(new FlowLayout(FlowLayout.LEADING));
            setSize(316, 338);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            Dimension preferredSize = new Dimension(300,300);
            Font font = new Font("", 1, 80);
            //设置button 大小，文字等属性
            close.setPreferredSize(preferredSize);
            close.setFont(font);
            close.setBorderPainted(true);
            close.setFocusable(false);
            add(close);
            //点击button后，程序终止。
            close.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isStop = true;
                    dispose();
                }
            });
        }
    }
    //
    public static void main( String[] args )
    {
        App m = new App();
        m.run();
    }
}
