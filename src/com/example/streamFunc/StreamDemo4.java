package com.example.streamFunc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Author: Leo Brown
 * Description: jdk8 stream流的并行流
 * Date: 2022-07-12 16:16:33
 */
public class StreamDemo4 {
    public static void main(String[] args) {
        //先并行 后串行
//        IntStream.range(1, 100).peek(StreamDemo4::debug).sequential().peek(StreamDemo4::debug).count();
        //并行流使用线程池:ForkJoinPool.commonPool
        //默认线程数是当前机器CPU个数
        //使用这个属性可以修改默认线程数
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","20");
        IntStream.range(1, 100).parallel().peek(StreamDemo4::debug).count();

        //使用自己的线程池，不使用默认线程池，防止任务被阻塞
        //线程名字:ForkJoinPool-1
        ForkJoinPool pool = new ForkJoinPool(20);
        pool.submit(()->IntStream.range(1,100).parallel().peek(StreamDemo4::debug).count());
        pool.shutdown();

        synchronized (pool){
            try{
                pool.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void debug(int i) {
        System.out.println(Thread.currentThread().getName() + " debug " + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
