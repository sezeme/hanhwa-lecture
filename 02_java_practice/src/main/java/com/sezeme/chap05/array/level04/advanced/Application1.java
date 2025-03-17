package com.sezeme.chap05.array.level04.advanced;

import java.util.Arrays;
import java.util.Random;

public class Application1 {
    public static void main(String[] args) {
        int[] iarr = new int[6];
        Random rand = new Random();

        int index = 0;
        loop:
        while(index < 6){
            int newNumber = rand.nextInt(1,46);
            boolean flag = false;
            for(int num : iarr) {
                if (num == newNumber) {
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            iarr[index++] = newNumber;
        }

        Arrays.sort(iarr);

        System.out.println(Arrays.toString(iarr));
    }
}
