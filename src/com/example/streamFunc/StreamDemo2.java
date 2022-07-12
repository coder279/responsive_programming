package com.example.streamFunc;

import java.util.Random;
import java.util.stream.Stream;

/**
 * Author: Leo Brown
 * Description: jdk8 stream流的中间操作
 * Date: 2022-07-12 16:16:33
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        String str = "My name is 007";
        Stream.of(str.split(" ")).filter(x -> x.length() > 2).map(x -> x.length()).forEach(System.out::println);

        //flatMap A->B属性(是个集合),最终得到所有A元素里所有B属性的元素集合
        //intStream/longStream并不是stream的子类，所以要进行装箱boxed
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed()).forEach(s -> {
            System.out.println((char) s.intValue());
        });
        // peek用于debug
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);
        // limit使用，主要用于无限流
        new Random().ints().filter(x -> x > 100 && x < 10000).limit(10).forEach(System.out::println);

    }
}
