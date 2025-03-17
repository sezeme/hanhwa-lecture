package com.sezeme.chap08.polymorphism.level01.basic;

import java.util.Objects;

public class Rectangle extends Shape implements Resizable {
    double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void resize(double factor) {
        width *= factor;
        height *= factor;
    }

    @Override
    double calculateArea() {
        return width * height;
    }

    @Override
    double calculatePerimeter() {
        return width*2 + height*2;
    }

    @Override
    public String toString() {
        return "Shape: Rectangle\nArea: " + calculateArea() + "\nPerimeter: " + calculatePerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || this.getClass() != o.getClass())
            return false;
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
