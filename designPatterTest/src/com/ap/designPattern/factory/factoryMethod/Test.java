package com.ap.designPattern.factory.factoryMethod;

class Test  {
    public static final void main(String[] args)
    {
        AbstractFactory simpleFactory = new ConcreteFactoryByRound();
        Shape shape = simpleFactory.creat();
        shape.clear();
        shape.draw();
    }
}