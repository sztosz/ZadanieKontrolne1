package com.sztosz.commandLine1;

import java.util.Scanner;

public class Main {

    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Main me = new Main();
        String input_string = null;
        Double height;
        Double baseWidth;
        String classes[] = new String[] {"Square", "EquilateralTriangle", "RightTriangle", "Rectangle"};
        Boolean dontBreakLoop = true;

        while (dontBreakLoop) {
            System.out.println("Please choose Geometric Figure:");
            System.out.println("Square");
            System.out.println("EquilateralTriangle");
            System.out.println("RightTriangle");
            System.out.println("Rectangle");
            input_string = me.input.nextLine();
            for (String cls : classes) {
                if (input_string.equals(cls)) {
                    dontBreakLoop = false;
                }
            }
        }

        System.out.println("Please enter base width :");
        baseWidth = me.input.nextDouble();
        System.out.println("Please enter height :");
        height = me.input.nextDouble();

        if (input_string.equals("Square")) {
            Square figure = new Square(height, baseWidth);
            System.out.println("Area :" + figure.getArea());
            System.out.println("Perimeter :" + figure.getPerimeter());
        } else if (input_string.equals("EquilateralTriangle")) {
            EquilateralTriangle figure = new EquilateralTriangle(height, baseWidth);
            System.out.println("Area :" + figure.getArea());
            System.out.println("Perimeter :" + figure.getPerimeter());
        } else if (input_string.equals("RightTriangle")) {
            RightTriangle figure = new RightTriangle(height, baseWidth);
            System.out.println("Area :" + figure.getArea());
            System.out.println("Perimeter :" + figure.getPerimeter());
        } else if (input_string.equals("Rectangle")) {
            Rectangle figure = new Rectangle(height, baseWidth);
            System.out.println("Area :" + figure.getArea());
            System.out.println("Perimeter :" + figure.getPerimeter());
        }


    }

}
