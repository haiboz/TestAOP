package com.com.singleton;

/**
 * 饱汉式（线程安全的实现）
 * public关键字
 */
public class SingletonTest3{
    private SingletonTest3(){}
    private static SingletonTest3 singleton = null;//没有final关键字
    public static synchronized SingletonTest3 getInstance(){
        if(singleton == null){
            singleton = new SingletonTest3();
        }
        return singleton;
    }
}
