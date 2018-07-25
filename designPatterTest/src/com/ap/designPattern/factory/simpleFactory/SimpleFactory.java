package com.ap.designPattern.factory.simpleFactory;

class SimpleFactory {


    public Shape creat(String shape) {
        if(shape.equals("Round"))
        {
            return new Round();
        }
        if(shape.equals("Triangle"))
        {
            return new Triangle();
        }
        return null;
    }
}



