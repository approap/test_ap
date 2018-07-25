package com.ap.designPattern.singleton;

public class SingletonDoubleCheck {

    private static SingletonDoubleCheck instance;
//    private volatile static SingletonDoubleCheck instance; //声明成 volatile
//  使用 volatile 的主要原因是其另一个特性：禁止指令重排序优化
    private SingletonDoubleCheck() {
    }

    public static SingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}