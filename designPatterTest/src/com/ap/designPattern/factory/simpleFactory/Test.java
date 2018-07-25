package com.ap.designPattern.factory.simpleFactory;

class Test  {
    public static final void main(String[] args)
    {
        SimpleFactory simpleFactory = new SimpleFactory();
        Shape shape = simpleFactory.creat("Round");
        shape = simpleFactory.creat("Triangle");
        shape.clear();
        shape.draw();
    }
}