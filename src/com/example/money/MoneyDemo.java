package com.example.money;

import java.text.DecimalFormat;
import java.util.function.Function;

/**
 * Author: Leo Brown
 * Description: jdk8函数接口，设置函数接口返回,可以进行链式操作,这种方式可以省略接口函数的定义，更加方便
 * Date: 2022-07-09 21:32:33
 */
interface ImoneyFormat {
    String format(int i);
}

class MyMoney {
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

//    public void showMyMoney(ImoneyFormat imoneyFormat){
//        System.out.println("我的存款 "+imoneyFormat.format(this.money));
//    }

    public void showMyMoney(Function<Integer, String> moneyFormat) {
        // 函数式接口应用操作apply
        System.out.println("我的存款: " + moneyFormat.apply(this.money));
    }
}

public class MoneyDemo {
    public static void main(String[] args) {
        MyMoney myMoney = new MyMoney(999999999);
        Function<Integer, String> integerStringFunction = i -> new DecimalFormat("#,###").format(i);

        myMoney.showMyMoney(integerStringFunction.andThen(s -> "人民币:" + s));
    }
}
