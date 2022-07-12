package com.example.curry;

import java.util.function.Function;

/**
 * Author: Leo Brown
 * Description: 柯里化表达式
 * Date: 2022-07-11 22:11:33
 */
public class CurryDemo {
    public static void main(String[] args) {
        Function<Integer,Function<Integer,Integer>> fun = x -> y -> x + y;
        System.out.println(fun.apply(1).apply(2));
    }
}
