package com.sztosz.commandLine1;

/**
 * Created by Bartosz Nowak on 2014-12-08.
 */
public class Square extends Figure2D implements GeometricFigure2D {

    public Square(Double height, Double baseWidth) throws ArithmeticException {
        super(height, baseWidth);
        if (!height.equals(baseWidth)) {
            throw new ArithmeticException("Height is not equal to width of base. The program should exit now.");
//        }
        }
    }


}
