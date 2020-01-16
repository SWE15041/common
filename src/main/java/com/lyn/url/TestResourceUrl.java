package com.lyn.url;

import java.net.URL;

public class TestResourceUrl {
    public static void main(String[] args) {

        System.out.println(">>>>>>>>>>>>>>>>JAVA路径获取相关>>>>>>>>>>>>>>>>");
        URL resource = TestResourceUrl.class.getResource("");
        System.out.println("类：" + resource);
        URL resource1 = TestResourceUrl.class.getResource("/");
        System.out.println("类 / ：" + resource1);

        URL resource2 = TestResourceUrl.class.getClassLoader().getResource("");
        System.out.println("类加载器：" + resource2);
        URL resource3 = TestResourceUrl.class.getClassLoader().getResource("/");
        System.out.println("类加载器 / ：" + resource3);

        URL resource4 = Thread.currentThread().getContextClassLoader().getResource("");
        System.out.println("当前类加载器：" + resource4);
        URL resource5 = Thread.currentThread().getContextClassLoader().getResource("/");
        System.out.println("当前类加载器 / ：" + resource5);
    }
}
