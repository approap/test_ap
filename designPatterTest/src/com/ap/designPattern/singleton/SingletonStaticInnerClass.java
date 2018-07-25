package com.ap.designPattern.singleton;

public class SingletonStaticInnerClass {
    private static class SingletonHolder {
        private static final SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass();
    }

    private SingletonStaticInnerClass() {
    }

    public static final SingletonStaticInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}