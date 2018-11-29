package com.example.alan.androidunittest.testlearn;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertThat;

/**
 * 自定义 IsMobilePhoneMatcher 演示
 */
public class PhoneTest {

    @Rule
    public final TestName name = new TestName();

    @Test
    public void testMatcher() {
        assertThat("13888888888", new IsMobilePhoneMatcher());
        assertThat("13578946824", new IsMobilePhoneMatcher());
    }

    @Test
    public void testConstructor() {

    }

    @Test
    public void getNumber() {
    }

    @Test
    public void setNumber() {
    }

    public class IsMobilePhoneMatcher extends BaseMatcher<String> {

        /**
         * 进行断言判定，返回true则断言成功，否则断言失败
         */
        @Override
        public boolean matches(Object item) {
            if (item == null) {
                return false;
            }
            Pattern pattern = Pattern.compile("(1|861)(3|5|7|8)\\d{9}$*");
            Matcher matcher = pattern.matcher((String) item);
            return matcher.find();
        }

        /**
         * 给期待断言成功的对象增加描述
         */
        @Override
        public void describeTo(Description description) {
            description.appendText("预计此字符串是手机号码！");
        }

        /**
         * 给断言失败的对象增加描述
         */
        @Override
        public void describeMismatch(Object item, Description description) {
            description.appendText(item.toString() + "不是手机号码！");
        }
    }
}


