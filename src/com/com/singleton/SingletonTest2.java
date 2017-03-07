package com.com.singleton;

/**
 * 饱汉式(线程不安全)-->写法简单 节约内存  线程不安全
 */
public class SingletonTest2{
    private SingletonTest2(){}
    private static SingletonTest2 singleton = null;//没有final关键字
    public static SingletonTest2 getInstance(){
        if(singleton == null){
            singleton = new SingletonTest2();
        }
        return singleton;
    }
}
