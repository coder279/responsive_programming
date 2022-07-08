package com.example.thread;

/**
 * Author: Leo Brown
 * Description: JDK8之前多线程代码与JDK8以后多线程代码对比(Lamda表达式的好处)
 * Date: 2022-07-08 16:11:33
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //JDK8以前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        }).start();

        //JDK8以后Lamda表达式
        new Thread(()-> System.out.println("ok")).start();

    }
}
