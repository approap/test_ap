package com.ap.designPattern.factory.abstractfactory;

class Triangle extends Shape {
    public void draw() {
        System.out.println("Triangle draw");
    }

    public void clear() {
        System.out.println("Triangle clear");
    }
}