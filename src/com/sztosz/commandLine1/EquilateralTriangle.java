package com.sztosz.commandLine1;

/**
 * Created by Bartosz Nowak on 2014-12-08.
 */
public class EquilateralTriangle extends Figure2D implements GeometricFigure2D{

    public EquilateralTriangle(Double height, Double baseWidth){
        super(height, baseWidth);
    }

    @Override
    public void calculateArea() {
        super.calculateArea();
        this.area = this.area / 2;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = this.baseWidth * 3;
    }
}
