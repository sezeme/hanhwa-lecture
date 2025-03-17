package com.sezeme.chap08.polymorphism.level01.basic;

import java.util.Objects;

public class Triangle extends Shape implements Resizable {
    double base, height, side1, side2, side3;

    Triangle(double base, double height, double side1, double side2, double side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public void resize(double factor) {
        base *= factor;
        height *= factor;
        side1 *= factor;
        side2 *= factor;
        side3 *= factor;
    }

    @Override
    double calculateArea() {
        return base * height / 2;
    }

    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Shape: Triangle\nArea: " + calculateArea() + "\nPerimeter: " + calculatePerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || this.getClass() != o.getClass())
            return false;
        Triangle triangle = (Triangle) o;
        return base == triangle.base && height == triangle.height && side1 == triangle.side1 && side2 == triangle.side2 && side3 == triangle.side3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, height, side1, side2, side3);
    }
}
