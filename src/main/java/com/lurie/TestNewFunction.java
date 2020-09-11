package com.lurie;

import com.lurie.lambda.Card;
import com.lurie.lambda.Man;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;

public class TestNewFunction {
    public static void main(String[] args) {
        TestNewFunction test = new TestNewFunction();
        test.testVar();
        test.testString();
        test.testCollection();
        test.testStream();
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
        var list = List.of("a", "b", "c");
        var listCopy = List.copyOf(list);
        //此方法创建的list是不可变的，对其执行add等操作会抛出异常
        System.out.println(list == listCopy);
        System.out.println(Arrays.toString(list.toArray(String[]::new)));
    }

    /**
     * Stream加强
     */
    private void testStream() {
        List<Man> mans = List.of(
                new Man("002", "李四", List.of(new Card("招商银行", "6225800002"), new Card("建设银行", "6227035248")))
                , new Man("003", "王五", List.of(new Card("建设银行", "6227056547"), new Card("中国银行", "6013832547"), new Card("民生银行", "4074058542")))
                , new Man("004", "赵六", List.of(new Card("工商银行", "9558832458"), new Card("工商银行", "9558832547"), new Card("建设银行", "6227032578")))
                , new Man("005", "孙七", List.of(new Card("中国银行", "6013825847"), new Card("农业银行", "6228836547"), new Card("招商银行", "6225014582")))
                , new Man("006", "张三", List.of(new Card("工商银行", "9558832587"), new Card("交通银行", "6222814578"), new Card("工商银行", "9558865427")))
                , new Man("007", "张三", List.of(new Card("招商银行", "1158832587"), new Card("交通银行", "6344814578"), new Card("工商银行", "2131133133"))));
        //遍历
        mans.forEach(m -> System.out.println(m.getName()));
        System.out.println("\n");
        // 获得所有Man名字的 list 集合
        mans.stream().map(Man::getName).collect(Collectors.toList()).forEach(System.out::println);
        //获取名字是张三的客户
        System.out.println("\n");
        mans.stream()
                .filter(man -> man.getName().equalsIgnoreCase("张三"))
                .map(Man::getName)
                .collect(Collectors.toList())
                .forEach(System.out::print);
        //获取名字是张三的一个客户
        System.out.println("\n");
        System.out.println(Objects.requireNonNull(mans.stream()
                .filter(man -> man.getName().equalsIgnoreCase("张三"))
                .findFirst().orElse(null)).getName());
        System.out.println("\n");
        //flatMap获取子流
        mans.stream()
                .filter(man -> man.getName().equalsIgnoreCase("张三"))
                .flatMap(man -> man.getCards().stream())
                .collect(Collectors.toList())
                .forEach(m -> System.out.println(m.getName()));

    }
}
