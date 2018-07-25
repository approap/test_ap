package com.ap.designPattern.factory.abstractfactory;

class ConcreteFactoryByRound extends AbstractFactory {

    public Shape creatShape() {
            return new Round();
    }
    public Sport doSport() {
            return new Soccer();
    }
}



