package com.example.lamda;

/**
 * Author: Leo Brown
 * Description: lamda表达式
 * Date: 2022-07-08 22:11:33
 */
public class LamdaDemo {
    public static void main(String[] args) {
        Object target1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        new Thread((Runnable) target1).start();

        // 使用Object作为类,后面就需要强转
        Object target = new Thread(()->System.out.println("OK"));
        new Thread((Runnable) target).start();
    }
}
