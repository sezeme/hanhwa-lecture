package com.sezeme.chap12.generic.level01.normal;

import java.util.Arrays;

public class Application1 {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("swap 전 : " + Arrays.toString(intArray));  // [1, 2, 3, 4, 5]
        swap(intArray, 1, 3);
        System.out.println("swap 후 : " + Arrays.toString(intArray));  // [1, 4, 3, 2, 5]

        String[] strArray = {"A", "B", "C", "D"};
        System.out.println("swap 전 : " + Arrays.toString(strArray));  // [A, B, C, D]
        swap(strArray, 0, 2);
        System.out.println("swap 후 : " + Arrays.toString(strArray));  // [C, B, A, D]
    }

    public static <T> void swap(T[] array, int index1, int index2) {

        if (array == null) {
            throw new IllegalArgumentException("배열은 null일 수 없습니다.");
        }

        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            throw new IndexOutOfBoundsException("인덱스가 배열의 범위를 벗어났습니다.");
        }

        if (index1 == index2) {
            return;
        }

        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
