package com.ap.designPattern.singleton;

public class SingletonLazyAndNotSafe {
    private static SingletonLazyAndNotSafe instance;
    private SingletonLazyAndNotSafe (){}
    public static SingletonLazyAndNotSafe getInstance() {
     if (instance == null) {
         instance = new SingletonLazyAndNotSafe();
     }
     return instance;
    }
}