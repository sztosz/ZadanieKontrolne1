package com.sztosz.commandLine1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.reflect.*;

public class Main {
    private Scanner input = new Scanner(System.in);

    private Map<String, Class<? extends Figure2D>> FigureTypes = new HashMap<String, Class<? extends Figure2D>>();
    private Class<? extends Figure2D> figure2D;


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Main me = new Main();
        me.populateFigureTypes();
        me.figure2D = me.getClassFromUserEntry();
        String abc = "com.sztosz.commandLine1.Rectangle";
//        Class figure_class = Class.forName(me.figure2D.toString());
//        Class figure_class = Class.forName(abc);
        Class figure_class = me.figure2D;
        Constructor figure_constructor = figure_class.getConstructor(Double.class, Double.class);
        Object figure = figure_constructor.newInstance(me.getDoubleFromInput("Height"), me.getDoubleFromInput("width of base"));
        Method getArea = figure_class.getMethod("getArea", null);
        Method getPerimeter = figure_class.getMethod("getPerimeter", null);
//        System.out.println(figure.getClass().toString());
        Double area = (Double) getArea.invoke(figure);
//        System.out.println(area);
        Double perimeter = (Double) getPerimeter.invoke(figure);
//        System.out.println(area);
        me.printDoubleValue("area", area);
        me.printDoubleValue("perimeter", perimeter);

    }

    private void populateFigureTypes() {
        this.FigureTypes.put("Square", Square.class);
        this.FigureTypes.put("EquilateralTriangle", EquilateralTriangle.class);
        this.FigureTypes.put("RightTriangle", RightTriangle.class);
        this.FigureTypes.put("Rectangle", Rectangle.class);
    }

    private void getFigureChoicesFromInput() {
        for (String entry : FigureTypes.keySet()) {
            System.out.println(entry);
        }
        System.out.println("Please choose Geometric Figure:");
    }

    private Double getDoubleFromInput(String variableName) {
        System.out.println("Please enter " + variableName + " :");
        return input.nextDouble();
    }

    private void printDoubleValue(String variableName, Double value){
        System.out.println("Value of " + variableName + " is: " + value.toString());
    }

    private Class<? extends Figure2D> getClassFromUserEntry() {
        String input_string;

        boolean continue_loop = true;
        while (continue_loop) {
            getFigureChoicesFromInput();
            input_string = input.nextLine();
            if (FigureTypes.containsKey(input_string)) {
                return FigureTypes.get(input_string);
            }
        }
        return null;
    }

}
