package com.vn.nhat.syntax.oop;

public class Circle {
    private static final double PI = 3.14;
    /**
     * Radius(Bán kính) of the circle
     *
     */
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Calucuate the area(Diện tích) of the circle
     *
     * @return area of the circle
     */
    public double area() {
        return PI * Math.pow(radius, 2);
    }

    /**
     * Calulcate the perimeter(Chu vi) of the circle
     *
     * @return perimeter of the circle
     */
    public double perimeter() {
        return 2 * PI * radius;
    }
}
