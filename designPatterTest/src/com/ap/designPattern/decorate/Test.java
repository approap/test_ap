package com.ap.designPattern.decorate;

public class Test {
    public static void main(String[] args) {
        Transform transform = new Transform(new Car());
        transform.make();
    }
}

class Transform {
    private Car car;
    public void make() {
        car.make();
        System.out.println("变形");
    }

    public Transform(Car car) {
        this.car = car;
    }
}

class Car {
    public void make() {
        System.out.println("汽车出发");

    }
}