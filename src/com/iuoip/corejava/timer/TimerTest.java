package com.iuoip.corejava.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TimerTest {
    public static void main(String[] args) {
        TimePrinter timePrinter = new TimePrinter();
        //构造一个定时器，没经过1秒通知timePrinter监听器一次
        Timer timer = new Timer(1000, timePrinter);
        //启动定时器。一旦启动，定时器将调用监听器的actionPerformed
        timer.start();
        //停止定时器。一旦停止，定时器将不再调用监听器的actionPerformed
//        timer.stop();

        //显示一条提示信息和OK按钮的对话框
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}

class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("at the tone,the time is" + Instant.ofEpochMilli(actionEvent.getWhen()));
        //Toolkit.getDefaultToolkit()获得默认的工具箱，beep()发出一声铃响
        Toolkit.getDefaultToolkit().beep();
    }
}