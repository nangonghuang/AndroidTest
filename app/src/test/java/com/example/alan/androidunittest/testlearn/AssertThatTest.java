package com.example.alan.androidunittest.testlearn;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * 自定义@RuLL  MyRule 演示
 */
public class AssertThatTest {

    @Rule
    public MyRule rule = new MyRule();

    @Test
    public void testAssertThat1() throws Exception {
        Assert.assertThat(6, CoreMatchers.is(6));
    }

    @Test
    public void testAssertThat2() throws Exception {
        Assert.assertThat(null, IsNull.nullValue());
    }

    @Test
    public void testAssertThat3() throws Exception {
        Assert.assertThat("Hello python world",CoreMatchers.both(CoreMatchers.startsWith("Hello")).and(CoreMatchers.endsWith("World")));
    }

    public class MyRule implements TestRule {

        @Override
        public Statement apply(final Statement base, final Description description) {

            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    // evaluate前执行方法相当于@Before
                    String methodName = description.getMethodName(); // 获取测试方法的名字
                    System.out.println(methodName + "测试开始！");

                    base.evaluate();  // 运行的测试方法

                    // evaluate后执行方法相当于@After
                    System.out.println(methodName + "测试结束！");
                }
            };
        }
    }

}
