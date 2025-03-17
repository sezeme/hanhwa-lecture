package com.sezeme.chap11.io.level01.basic;

import java.io.*;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원본 파일의 이름을 입력하세요 : ");
        String origin = sc.nextLine();
        System.out.print("복사 파일의 이름을 입력하세요 : ");
        String copy = sc.nextLine();

        // try-with-resources 사용하여 자동으로 close() 실행
        try (FileReader frOrigin = new FileReader(origin);
             FileWriter fos = new FileWriter(copy)) {

            char[] buffer = new char[1024]; // 1KB씩 읽기
            int length;

            // 파일 끝까지 반복해서 읽고 쓰기
            while ((length = frOrigin.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }

            System.out.println("파일 복사가 성공적으로 완료 되었습니다.");
        } catch (FileNotFoundException e) {
            System.out.println("오류 : " + origin + " (지정된 파일을 찾을 수 없습니다)");
        } catch (IOException e) {
            System.out.println("파일 복사 중 오류 발생: " + e.getMessage());
        }
    }
}
