package com.sezeme.test;

public class Test{
    private int val;
    public Test(int val){
        this.val = val;
    }
    public static void main(String[] args) {
        Test a = new Test(10);
        Test b = new Test(10);
        Test c = a;
        int d = 10;
        double e = 10.0;
        System.out.println(a == c);
        System.out.println(d == e);
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(d == 10.0);
    }
    }