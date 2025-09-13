package com.vn.nhat.syntax.oop;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius) {
        super(radius);
    }

    public double volume() {
        return area() * height;
    }
}
