package com.com.singleton;

/**
 * 饿汉式-->线程安全 但效率较低 类被加载时就实例化好 略占内存
 * Created by 浮生若梦 on 2017/3/7.
 */
public class SingletonTest1 {
    //定义一个私有的构造方法
    private SingletonTest1(){}
    private static final SingletonTest1 singleton = new SingletonTest1();
    public SingletonTest1 getInstance(){
        return singleton;
    }
}




