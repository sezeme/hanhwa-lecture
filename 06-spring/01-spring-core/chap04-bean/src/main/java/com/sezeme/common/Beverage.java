package com.sezeme.common;

public class Beverage extends Product {
    private int capacity; //용량

    public Beverage() {
        super();
    }

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @Override
    public String toString() {
        return super.toString() + " " + this.capacity;
    }
}