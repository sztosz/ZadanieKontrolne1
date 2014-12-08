package com.sztosz.commandLine1;

import java.lang.Math;

/**
 * Created by Bartosz Nowak on 2014-12-08.
 */
public class RightTriangle extends Figure2D implements GeometricFigure2D {

    public RightTriangle(Double height, Double baseWidth){
        super(height, baseWidth);
    }

    @Override
    public void calculateArea() {
        super.calculateArea();
        this.area = this.area / 2;
    }

    @Override
    public void calculatePerimeter() {
        double hypotenuse = Math.sqrt(Math.pow(this.height, 2) + Math.pow(this.baseWidth, 2));
        this.perimeter = hypotenuse + this.height + this.baseWidth;
    }

}
