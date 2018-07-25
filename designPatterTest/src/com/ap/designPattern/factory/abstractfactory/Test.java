package com.ap.designPattern.factory.abstractfactory;

class Test  {
    public static final void main(String[] args)
    {
        AbstractFactory simpleFactory = new ConcreteFactoryByRound();
        Shape shape = simpleFactory.creatShape();
        shape.clear();
        shape.draw();
        Sport sport = simpleFactory.doSport();
        sport.doSport();
        sport.undoSport();
    }
}