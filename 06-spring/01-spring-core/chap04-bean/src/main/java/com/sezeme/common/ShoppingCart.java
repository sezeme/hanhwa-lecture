package com.sezeme.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> items; //쇼핑카트에 담긴 상품들

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product item) {
        items.add(item);
    }

    public List<Product> getItem() {
        return items;
    }
}