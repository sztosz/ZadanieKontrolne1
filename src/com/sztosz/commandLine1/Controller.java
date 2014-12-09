package com.sztosz.commandLine1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Bartosz Nowak on 2014-12-09.
 */
public class Controller {

    private Scanner input = new Scanner(System.in);

    private Map<String, Class<? extends Figure2D>> FigureTypes = new HashMap<String, Class<? extends Figure2D>>();
    private Class<? extends Figure2D> figure_class;
    private InnerObject innerObject;

    public Controller() throws NoSuchMethodException, InstantiationException, IllegalAccessException {

        populateFigureTypes();
        getObjectFromClass();
    }

    class InnerObject {

        private Object figure;
        private Method getArea;
        private Method getPerimeter;

        public InnerObject(Object figure, Method getArea, Method getPerimeter) {
            this.figure = figure;
            this.getArea = getArea;
            this.getPerimeter = getPerimeter;
        }

        private Double getArea() throws InvocationTargetException, IllegalAccessException {
            return (Double)this.getArea.invoke(this.figure);
        }

        private Double getPerimeter() throws InvocationTargetException, IllegalAccessException {
            return (Double)this.getPerimeter.invoke(this.figure);
        }
    }

    public Double getArea() throws InvocationTargetException, IllegalAccessException {
        return innerObject.getArea();
    }

    public Double getPerimeter() throws InvocationTargetException, IllegalAccessException {
        return innerObject.getPerimeter();
    }

    public void populateFigureTypes() {
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

    public void getObjectFromClass() throws NoSuchMethodException, IllegalAccessException, InstantiationException {
        try {
            figure_class = getClassFromUserEntry();
            Constructor figure_constructor = figure_class.getConstructor(Double.class, Double.class);
            this.innerObject = new InnerObject(
                    figure_constructor.newInstance(getDoubleFromInput("Height"), getDoubleFromInput("width of base")),
                    figure_class.getMethod("getArea"),
                    figure_class.getMethod("getPerimeter"));
        } catch (InvocationTargetException invocationTargetException) {
            String exception = invocationTargetException.getTargetException().toString();
            System.out.println(exception);
            System.exit(1);
        }
    }
}
