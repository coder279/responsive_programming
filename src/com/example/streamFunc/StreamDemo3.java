package com.example.streamFunc;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: Leo Brown
 * Description: jdk8 stream流的中间操作
 * Date: 2022-07-12 16:16:33
 */
public class StreamDemo3 {
    public static void main(String[] args) {
        String str = "My name is 007";
        //使用并行流
        str.chars().parallel().forEach(System.out::println);
        System.out.println("\n");
        //使用并行流保证顺序
        str.chars().parallel().forEachOrdered(System.out::println);
        //收集List
        List<String> list = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(list);
        //使用reduce拼接字符串
        Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        System.out.println(letters.orElse(" "));
        //使用reduce带初始值
        String letters1 = Stream.of(str.split(" ")).reduce("", (s1, s2) -> s1 + "|" + s2);
        System.out.println(letters1);
        //计算单词总长度
        Integer length = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(length);
        //max min操作
        String result = Stream.of(str.split(" ")).max((s1, s2) -> s1.length() - s2.length()).get();
        System.out.println(result);
        //使用findFirst短路操作
        OptionalInt findFirst = new Random().ints().findFirst();
        System.out.println(findFirst.getAsInt());

    }
}
