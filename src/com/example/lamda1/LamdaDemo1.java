package com.example.lamda1;

/**
 * Author: Leo Brown
 * Description: 函数接口,只能有一个实现方法,jdk8新增的默认方法
 * Date: 2022-07-09 21:32:33
 */
@FunctionalInterface
interface Interface1 {
    int doubleNum(int i);

    default int add(int x, int y) {
        return x + y;
    }
}

@FunctionalInterface
interface Interface2 {
    int doubleNum(int i);

    default int add(int x, int y) {
        return x + y;
    }
}

/**
 * 继承的情况要实现父类的自带的方法
 */
@FunctionalInterface
interface Interface3 extends Interface1,Interface2 {
    @Override
    default int add(int x, int y) {
        return Interface1.super.add(x, y);
    }
}


public class LamdaDemo1 {
    public static void main(String[] args) {
        Interface1 i1 = (i) -> i * 2;
        System.out.println(i1.doubleNum(3));
        System.out.println(i1.add(1, 2));
    }
}
