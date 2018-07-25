package com.ap.designPattern.factory.factoryMethod;

class ConcreteFactoryByRound extends AbstractFactory {

    public Shape creat() {
            return new Round();
    }
}



