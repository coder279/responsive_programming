package com.example.function;

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Author: Leo Brown
 * Description: 函数式接口例子，在使用函数接口尽量使用这种带有基础类型的
 * Date: 2022-07-09 22:11:33
 */
public class FunctionDemo {
    //断言函数接口
    public static void main(String[] args) {
        //指定类型的断言
        IntPredicate predicate = i -> i > 0;
        //泛型的断言
        Predicate<Integer> predicate1 = x -> x > 0;
        System.out.println(predicate.test(-6));
        System.out.println(predicate1.test(1));

        //消费类型的接口
        Consumer<String> consumer = s-> System.out.println(s);
        consumer.accept("输入的数据");
    }
}
