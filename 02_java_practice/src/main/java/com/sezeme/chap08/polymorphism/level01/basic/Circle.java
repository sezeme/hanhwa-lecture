package com.sezeme.chap08.polymorphism.level01.basic;

import java.util.Objects;

public class Circle extends Shape implements Resizable {
    double radius;

    Circle(double radius) {this.radius = radius; }
    //Circle() {} 기본생성자 없으면 자동생성 해주나?

    @Override
    double calculateArea() {
        return radius * radius * Math.PI;
    }
    @Override
    double calculatePerimeter() {
        return radius * Math.PI * 2;
    }

    @Override
    public void resize(double factor){
        radius *= factor;
    }

    @Override
    public String toString() {
        return "Shape: Circle\nArea: " + calculateArea() + "\nPerimeter: " + calculatePerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || this.getClass() != o.getClass())
            return false;

        return radius == ((Circle) o).radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
