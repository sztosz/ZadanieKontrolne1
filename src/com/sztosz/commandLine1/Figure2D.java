package com.sztosz.commandLine1;

/**
 * Created by Bartosz Nowak on 2014-12-08.
 */
public abstract class Figure2D implements GeometricFigure2D {

    protected Double height;
    protected Double baseWidth;
    protected Double area;
    protected Double perimeter;


    protected Figure2D(Double height, Double baseWidth) {
        setHeight(height);
        setBaseWidth(baseWidth);
        calculateArea();
        calculatePerimeter();
    }

    @Override
    public void calculateArea() {
        this.area = this.baseWidth * this.height;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = this.baseWidth * 2 + this.height * 2;
    }

    @Override
    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public void setBaseWidth(Double baseWidth) {
        this.baseWidth = baseWidth;
    }

    @Override
    public Double getArea() {
        return this.area;
    }

    @Override
    public Double getPerimeter() {
        return this.perimeter;
    }
}
