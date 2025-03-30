/**
 * 컴퓨터학부 글로벌소프트웨어융합전공
 * 2024003159 황부연
 * 2025년 3월 26일
 * 과제03 - 경주게임
 */

import java.util.Scanner;

public class RaceApp {
    public static void main(String[] args) {
        System.out.println("T(0)");
        System.out.println("H(0)");
        System.out.println("Type Enter to Start Race !!!");

        System.out.println("-".repeat(50));

        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();

        Race race = new Race();

        while (!race.isEnd()) {
            race.moveTortoise();
            race.moveHare();
            race.printRace();

            try {
                Thread.sleep(500); // 500 msec 지연
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        int tPos = race.getDisplayTortoisePosition();
        int hPos = race.getDisplayHarePosition();

        if (tPos == hPos) {
            System.out.println("Even Game!");
        } else {
            if (tPos > hPos) {
                System.out.print("Tortoise Wins!");
            }
            else {
                System.out.print("Hare Wins!");
            }

            System.out.printf("(Hare: %d, Tortoise: %d)\n", hPos, tPos);
        }

    }
}