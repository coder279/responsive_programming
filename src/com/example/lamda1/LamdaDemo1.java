package com.example.lamda1;


/**
 * Author: Leo Brown
 * Description: 函数接口,只能有一个方法
 * Date: 2022-07-09 21:32:33
 */
@FunctionalInterface
interface Interface1 {
    int doubleNum(int i);
}

public class LamdaDemo1 {
    public static void main(String[] args) {
        Interface1 i1 = (i) -> i * 2;
        System.out.println(i1);
    }
}
