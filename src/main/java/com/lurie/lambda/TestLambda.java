package com.lurie.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestLambda {

    public static void main(String[] args) {
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
        mans.stream().map(man -> man.getName()).collect(Collectors.toList()).forEach(System.out::println);
        //获取名字是张三的客户
        System.out.println("\n");
        mans.stream()
                .filter(man -> man.getName().equalsIgnoreCase("张三"))
                .map(man -> man.getName())
                .collect(Collectors.toList())
                .forEach(System.out::print);
        //获取名字是张三的一个客户
        System.out.println("\n");
        System.out.println(mans.stream().filter(man -> man.getName().equalsIgnoreCase("张三"))
                .findFirst().orElse(null).getName());
        System.out.println("\n");
        //flatMap获取子流
        mans.stream().filter(man -> man.getName().equalsIgnoreCase("张三")).flatMap(man -> man.getCards().stream()).collect(Collectors.toList()).forEach(m -> System.out.println(m.getName()));

    }
}
