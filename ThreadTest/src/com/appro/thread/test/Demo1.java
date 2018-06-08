package com.appro.thread.test;
// Demo1.java
// �ֿ�
class Depot {
    private int capacity;    // �ֿ������
    private int size;        // �ֿ��ʵ������

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public synchronized void produce(int val) {
        try {
             // left ��ʾ����Ҫ������������(�п���������̫�࣬��������)
            int left = val;
            while (left > 0) {
                // �������ʱ���ȴ��������ߡ����Ѳ�Ʒ��
                while (size >= capacity)
                    wait();
                // ��ȡ��ʵ��������������(�����������������)
                // �������桱+����Ҫ������������>���ܵ�����������ʵ��������=���ܵ�������-����ǰ��������(��ʱ�����ֿ�)
                // ����ʵ��������=����Ҫ������������
                int inc = (size+left)>capacity ? (capacity-size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n", 
                        Thread.currentThread().getName(), val, left, inc, size);
                // ֪ͨ�������ߡ����������ˡ�
                notifyAll();
            }
        } catch (InterruptedException e) {
        }
    } 

    public synchronized void consume(int val) {
        try {
            // left ��ʾ���ͻ�Ҫ����������(�п���������̫�󣬿�治������������)
            int left = val;
            while (left > 0) {
                // ���Ϊ0ʱ���ȴ��������ߡ�������Ʒ��
                while (size <= 0)
                    wait();
                // ��ȡ��ʵ�����ѵ�������(�������ʵ�ʼ��ٵ�����)
                // �������桱<���ͻ�Ҫ���ѵ�����������ʵ����������=����桱��
                // ���򣬡�ʵ����������=���ͻ�Ҫ���ѵ���������
                int dec = (size<left) ? size : left;
                size -= dec;
                left -= dec;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n", 
                        Thread.currentThread().getName(), val, left, dec, size);
                notifyAll();
            }
        } catch (InterruptedException e) {
        }
    }

    public String toString() {
        return "capacity:"+capacity+", actual size:"+size;
    }
} 

// ������
class Producer {
    private Depot depot;
    
    public Producer(Depot depot) {
        this.depot = depot;
    }

    // ������Ʒ���½�һ���߳���ֿ���������Ʒ��
    public void produce(final int val) {
        new Thread() {
            public void run() {
                depot.produce(val);
            }
        }.start();
    }
}

// ������
class Customer {
    private Depot depot;
    
    public Customer(Depot depot) {
        this.depot = depot;
    }

    // ���Ѳ�Ʒ���½�һ���̴߳Ӳֿ������Ѳ�Ʒ��
    public void consume(final int val) {
        new Thread() {
            public void run() {
                depot.consume(val);
            }
        }.start();
    }
}



public class Demo1 {  
    public static void main(String[] args) {  
        Depot mDepot = new Depot(100);
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}