package com.example.alan.androidunittest.testlearn;

import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

/**
 * 自定义@RuLL  RepeatRule 演示
 */
public class RepeatTest {
    @Rule
    public final RepeatRule repeatRule = new RepeatRule();

    @RepeatRule.Repeat(count = 5)
    @Test
    public void testMethod() throws IOException {
        System.out.println("---test method---");
    }

    @Test
    public void testMethod2() throws IOException {
        System.out.println("---test method2---");
    }
}

