package com.example.alan.androidunittest.testlearn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

/**
 * 首先在测试类上添加注解@RunWith(Parameterized.class)，
 * 在创建一个由 @Parameters 注解的public static方法，让返回一个对应的测试数据集合。
 * 最后创建构造方法，方法的参数顺序和类型与测试数据集合一一对应。
 */
@RunWith(Parameterized.class)
public class DateFormatTest {

    private String time;

    public DateFormatTest(String time) {
        this.time = time;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList("2017-10-15",
//                "2017-10-15 16:00:02", // 抛出异常
                "2017年10月15日 16时00分02秒");
    }

    @Test(expected = ParseException.class)
    public void dateToStampTest1() throws Exception {
        DateUtil.dateToStamp(time);
    }
}