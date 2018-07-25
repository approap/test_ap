package com.ap.designPattern.proxy;

public class Test {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        parent.setChild(child);
        parent.lunch();
    }
}

class Parent {
    private Child child;

    public void setChild(Child child) {
        this.child = child;
    }

    public void lunch()
    {
       this.feed();
       this.eat();
       this.wash();
    }


    public void feed()
    {
        System.out.println("parent feed");
    }

    public void eat()
    {
        this.child.eat();
    }


    public void wash()
    {
        System.out.println("parent wash");
    }

}

// 变压器
class Child {
    public void eat() {
        System.out.println("child eat");
    }
}