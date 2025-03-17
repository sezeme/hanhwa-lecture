package com.sezeme.chap03.normal;

import java.util.Random;

public class RandomMaker {
    static Random rand = new Random();
    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static String randomUpperAlphabet(int length) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<length; i++){
//            char ch = (char) (Math.random() * ('Z' - 'A' + 1) + 'A');
            char ch = (char) rand.nextInt('A', 'Z'+1);
            result.append(ch);
        }
        return result.toString();
    }

    public static String rockPaperScissors() {
        int num = rand.nextInt(0,3);
        if(num == 0) return "가위";
        else if(num == 1) return "바위";
        return "보";
    }

    public static String tossCoin() {
        int num = rand.nextInt(2);
        if(num == 0) return "앞면";
        return "뒷면";
    }
}
