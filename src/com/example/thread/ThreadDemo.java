package com.example.thread;

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
