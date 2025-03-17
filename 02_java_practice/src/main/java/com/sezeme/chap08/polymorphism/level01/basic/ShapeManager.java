package com.sezeme.chap08.polymorphism.level01.basic;

public class ShapeManager {
    private Shape[] shapes = new Shape[10];
    private int index;

    public void addShape(Shape shape){
        if(index >= shapes.length){
            Shape[] arr = new Shape[shapes.length * 2];
            System.arraycopy(shapes,0, arr, 0, index);
//          shapes = Arrays.copyOf(shapes, shapes.length * 2);
            shapes = arr;
        }
        shapes[index++] = shape;
    }

    public void removeShape(Shape shape) {
        boolean hasFound = false;
        for(int i = 0; i < index; i++){
            if(hasFound && i != index-1){
                shapes[i] = shapes[i+1];
            } else if(!hasFound && shapes[i].equals(shape)){
                hasFound = true;
                i--;
            }
        }
        shapes[index - 1] = null;
        index--;
    }
    //equals를 해줄 때 오버라이딩을 해줘야하지 않나? -> 주소만으로 현재는 비교해줘도 충분히 동작함
    //그러나 동등객체를 비교할 때는 equals 오버라이딩이 필요함.

    public void printAllShapes() {
        for(int i = 0; i < index; i++){
            System.out.println(shapes[i]);
        }
    }

    public double getTotalArea() {
        double totalArea = 0;
        for(int i = 0; i < index; i++){
            totalArea += shapes[i].calculateArea();
        }
        return totalArea;
    }
    public double getTotalPerimeter() {
        double totalPerimeter = 0;
        for(int i = 0; i < index; i++){
            totalPerimeter += shapes[i].calculatePerimeter();
        }
        return totalPerimeter;
    }
}
