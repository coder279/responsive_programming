package com.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Author Leo Brown
 * Description 函数式编程与命令式编程
 * Date 2022-07-05 22:54:45
 */
public class Main {

    public static void main(String[] args) {
        // 命令式编程:取数组中的最小值
        int []nums = {1,2,3,4,5,6,-1,10};
        int minNum = 0;
        for( int i = 0; i < nums.length; i++){
            if(nums[i] < minNum){
                minNum = nums[i];
            }
        }
        System.out.printf("输出的最小值:%d\n",minNum);

        // 函数式编程:取数组最小值
        minNum = IntStream.of(nums).min().getAsInt();
        System.out.printf("输出的最小值:%d\n",minNum);
    }
}
