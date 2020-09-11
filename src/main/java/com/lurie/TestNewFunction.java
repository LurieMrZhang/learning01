package com.lurie;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestNewFunction {
    public static void main(String[] args) {
        TestNewFunction test = new TestNewFunction();
        test.testVar();
        test.testString();
        test.testCollection();
    }

    /**
     * 本地变量类型推断
     */
    private void testVar() {
        var testString = "testVar";
        System.out.println(testString);
    }

    /**
     * 字符串增强
     */
    private void testString() {
        var testString = "  ";
        //字符串是否是空白
        System.out.println(testString.isBlank());
        testString = " a ";
        //去除字符串首 尾部空格
        System.out.println(testString.strip());
        testString = " a ";
        //去除字符串首部空格
        System.out.println(testString.stripLeading());
        testString = " a ";
        //去除字符串尾部空格
        System.out.println(testString.stripTrailing());
        testString = "a";
        //复制N次字符串
        System.out.println(testString.repeat(2));
        //统计字符串行数
        testString = "a\nb\n\n\nb";
        System.out.println(testString.lines().count());
    }

    /**
     * 集合加强😂
     */
    private void testCollection() {
        var list= List.of("a","b","c");
        var listCopy=List.copyOf(list);
        //此方法创建的list是不可变的，对其执行add等操作会抛出异常
        System.out.println(list==listCopy);
        System.out.println(Arrays.toString(list.toArray(String[]::new)));
    }
    /**
     * Stream加强
     */
    private void testStream(){

    }
}
