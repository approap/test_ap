package com.appro.thread.test;
// Demo.java µÄÔ´Âë
class MyThread extends Thread{  
    public MyThread(String name) {
        super(name);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" is running");
    } 
}; 

public class Demo {  
    public static void main(String[] args) {  
        Thread mythread=new MyThread("mythread");

        System.out.println(Thread.currentThread().getName()+" call mythread.run()");
        mythread.run();

        System.out.println(Thread.currentThread().getName()+" call mythread.start()");
        mythread.start();
    }  
}