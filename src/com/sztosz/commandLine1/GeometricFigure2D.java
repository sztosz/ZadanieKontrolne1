package com.sztosz.commandLine1;

/**
 * Created by Bartosz Nowak on 2014-12-08.
 *
 * Interface that contains all the methods that any 2D Geometric Figure should contain
 */
public interface GeometricFigure2D {

    public void calculateArea();
    public void calculatePerimeter();
    public void setHeight(Double height);
    public void setBaseWidth(Double baseWidth);

    public Double getArea();
    public Double getPerimeter();

}
