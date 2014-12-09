package com.sztosz.commandLine1;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Controller controller = new Controller();
        printDoubleValue("area", controller.getArea());
        printDoubleValue("perimeter", controller.getPerimeter());

    }

    public static void printDoubleValue(String variableName, Double value){
        System.out.println("Value of " + variableName + " is: " + value.toString());
    }

}
