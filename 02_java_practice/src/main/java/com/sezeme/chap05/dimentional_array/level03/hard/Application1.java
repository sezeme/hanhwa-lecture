package com.sezeme.chap05.dimentional_array.level03.hard;

import java.util.Random;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int width, height;

        while(true) {
            System.out.print("가로 행의 수를 입력하세요 : ");
            width = sc.nextInt();
            if(width >= 1 && width <= 10) break;
            System.out.println("반드시 1~10까지의 정수를 입력해야합니다. 다시 입력해주세요.");
        }

        while(true) {
            System.out.print("세로 행의 수를 입력하세요 : ");
            height = sc.nextInt();
            if(height >= 1 && height <= 10) break;
            System.out.println("반드시 1~10까지의 정수를 입력해야합니다. 다시 입력해주세요.");
        }

        char[][] arr = new char[height][width];
        for(int i = 0; i<height; i++) {
            arr[i] = new char[width];
            for(int j = 0; j<width; j++){
                arr[i][j] = (char) rand.nextInt('A','Z'+1);
            }
        }

        for(int i = 0; i<height; i++) {
            for(int j = 0; j<width; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
