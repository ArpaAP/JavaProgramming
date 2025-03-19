/**
 * 컴퓨터학부 글로벌소프트웨어융합전공
 * 2024003159 황부연
 * 2025년 3월 12일
 * 과제01 - 생일초
 */

import java.util.Scanner;

public class BirthdayCandle {
    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type your age: ");
        int age = scanner.nextInt();

        if (age == 0) {
            System.out.println("Exit Program");
            scanner.close();
            return;
        }

        // 초 개수 계산
        int redCount = age / 10;
        age %= 10;

        int blueCount = age / 5;
        age %= 5;

        int yellowCount = age;

        int totalCount = redCount + blueCount + yellowCount;

        // 결과 출력
        System.out.println("Red candles: " + redCount);
        System.out.println("Blue candles: " + blueCount);
        System.out.println("Yellow candles: " + yellowCount);

        System.out.println("Total number of candles: " + totalCount);

        System.out.println("Exit Program");
        scanner.close();
    }
}