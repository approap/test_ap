package com.appro.thread.test;
// SleepLockTest.java?????(????synchronized(obj))
public class SleepLockTest{ 

    private static Object obj = new Object();

    public static void main(String[] args){ 
        ThreadA t1 = new ThreadA("t1"); 
        ThreadA t2 = new ThreadA("t2"); 
        t1.start(); 
        t2.start();
    }
    static class ThreadA extends Thread{
        public ThreadA(String name){ 
            super(name); 
        } 
        public void run(){ 
            // ???obj??????????
            synchronized (obj) {
//                try {
                    for(int i=0; i <10; i++){ 
                        System.out.printf("%s: %d\n", this.getName(), i); 
                        // i???4???????????100????
                        if (i%4 == 0)
//                            Thread.sleep(100);
                        yield();
                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        } 
    } 
}