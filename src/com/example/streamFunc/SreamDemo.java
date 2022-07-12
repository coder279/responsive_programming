package com.example.streamFunc;

import java.util.stream.IntStream;

/**
 * Author: Leo Brown
 * Description: jdk8 stream流处理
 * Date: 2022-07-09 21:32:33
 */
public class SreamDemo {
    public static void main(String[] args) {
        //外部迭代
        int sum = 0;
        int[] nums = {1, 2, 3};
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.printf("结果为:%d\n", sum);
        //内部迭代
        int sum1 = IntStream.of(nums).sum();
        System.out.printf("结果为:%d\n", sum1);

        //惰性操作 -- 中间结果就是惰性操作(返回stream)

        //终止操作 -- 求和是终止操作
    }
}
