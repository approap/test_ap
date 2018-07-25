package com.ap.designPattern.singleton;

/**
 * 不适用于实例依赖参数或者配置文件
 */
public class SingletonHungry {
    private static final SingletonHungry instance = new SingletonHungry();
    private SingletonHungry(){}
    public static SingletonHungry getInstance() {
     return instance;
    }
}