/**
 * 컴퓨터학부 글로벌소프트웨어융합전공
 * 2024003159 황부연
 * 2025년 4월 22일
 * 과제05,06 - 통합예약
 */

import java.util.Scanner;

public class ReservationSystemApp {
    public static void printMenu() {
        System.out.println("-".repeat(30));
        System.out.println("  통합 예약 시스템을 방문해 주셔서 감사합니다.");
        System.out.println("   1. 항공사 예약 시스템");
        System.out.println("   2. 버스 예약 시스템");
        System.out.println("   0. 통합 예약 시스템 종료");
        System.out.println("-".repeat(30));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AirlineSystem airlineSystem = new AirlineSystem("항공사 예약 시스템", scanner);
        BusSystem busSystem = new BusSystem("버스 예약 시스템", scanner);

        int choice;

        do {
            printMenu();
            System.out.print("메뉴를 선택해주세요: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    airlineSystem.menu();
                    break;
                case 2:
                    busSystem.menu();
                    break;
                case 0:
                    System.out.println("통합 예약 시스템을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요 (0~2)");
            }
        } while (choice != 0);

        scanner.close();
    }
}