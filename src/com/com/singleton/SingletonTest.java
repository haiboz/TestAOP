package com.com.singleton;

/**
 * 最优化单例模式 线程安全 效率高
 * Created by 浮生若梦 on 2017/3/7.
 */
public class SingletonTest {
    private SingletonTest(){}
    private static SingletonTest singleton;
    public static SingletonTest getInstance(){
        //如果不为null 直接返回 如果为null 使用同步代码块 进行实例化
        if(singleton == null){
            synchronized (SingletonTest.class){
                if(singleton == null){
                    singleton = new SingletonTest();
                }
            }
        }
        return singleton;
    }
}
