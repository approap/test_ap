package com.ap.designPattern.singleton;

public class SingletonLazyAndSafe {
    private static SingletonLazyAndSafe instance;
    private SingletonLazyAndSafe(){}
    public static synchronized SingletonLazyAndSafe getInstance() {
     if (instance == null) {
         instance = new SingletonLazyAndSafe();
     }
     return instance;
    }
}