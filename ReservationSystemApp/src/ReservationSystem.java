/**
 * 컴퓨터학부 글로벌소프트웨어융합전공
 * 2024003159 황부연
 * 2025년 4월 22일
 * 과제05,06 - 통합예약
 */

import java.util.Scanner;

public class ReservationSystem implements ReservationInterface {
    public String title;

    public int rows;
    public int cols;
    public int spaceIdx;

    public Scanner scanner;
    public boolean[][] seats;
    public char[] seatChar;

    public int occupied;
    public int capacity;

    public ReservationSystem(String title, Scanner scanner, int row, int col, int spaceIdx) {
        this.title = title;
        this.scanner = scanner;
        this.rows = row;
        this.cols = col;
        this.spaceIdx = spaceIdx;
        this.seatChar = new char[rows];
        this.occupied = 0;
        this.capacity = rows * cols;

        makeSeats(row, col);
    }


    @Override
    public void makeSeats(int row, int col) {
        seats = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                seats[i][j] = false;
            }
        }
    }

    @Override
    public boolean reserveSeat(String seatName) {
        int[] seatArray = new int[2];

        if (!getSeatIndex(seatName, seatArray)) {
            System.out.printf("[예약 실패] %s\n", seatName);
            return false;
        }

        int row = seatArray[0];
        int col = seatArray[1];

        if (seats[row][col]) {
            System.out.printf("[예약 실패] %s: 이미 예약된 좌석입니다.\n", seatName);
            return false;
        }

        seats[row][col] = true;
        occupied++;
        System.out.printf("[예약 성공] %s\n", seatName);
        return true;
    }

    @Override
    public boolean cancelSeat(String seatName) {
        int[] seatArray = new int[2];

        if (!getSeatIndex(seatName, seatArray)) {
            System.out.printf("[예약 취소 실패] %s\n", seatName);
            return false;
        }

        int row = seatArray[0];
        int col = seatArray[1];

        if (!seats[row][col]) {
            System.out.printf("[예약 취소 실패] %s: 예약되지 않은 좌석입니다.\n", seatName);
            return false;
        }

        seats[row][col] = false;
        occupied--;
        System.out.printf("[예약 취소 성공] %s\n", seatName);
        return true;
    }

    @Override
    public boolean getSeatIndex(String seatName, int[] seatArray) {
        if (seatName.length() < 2 || seatName.length() > 3) {
            System.out.printf("%s: 잘못된 좌석 번호입니다.\n", seatName);
            return false;
        }

        if (!Character.isDigit(seatName.charAt(0))) {
            System.out.printf("%s: 숫자가 아닙니다.\n", seatName);
            return false;
        }

        char startChar = (char) ('A' + rows - 1);
        int row = startChar - seatName.charAt(seatName.length() - 1);

        if (row < 0 || row >= rows) {
            System.out.printf("%s: 잘못된 좌석 번호입니다.\n", seatName);
            return false;
        }

        try {
            int col = Integer.parseInt(seatName.substring(0, seatName.length() - 1)) - 1;

            if (col < 0 || col >= cols) {
                System.out.printf("%s: 잘못된 좌석 번호입니다.\n", seatName);
                return false;
            }

            seatArray[0] = row;
            seatArray[1] = col;

            return true;
        } catch (NumberFormatException e) {
            System.out.printf("%s: 잘못된 좌석 번호입니다.\n", seatName);
            return false;
        }
    }

    @Override
    public void displaySeat(String companyName) {
        System.out.printf("[%s 예약 현황] 예약 좌석: %d/총 좌석: %d\n", companyName, occupied, capacity);
        System.out.println();

        for (int i = 0; i < rows; i++) {
            if (i == spaceIdx) {
                System.out.println("-".repeat(58));
                System.out.println("앞" + " ".repeat(27) + "통로" + " ".repeat(27) + "뒤");
                System.out.println("-".repeat(58));
            }

            for (int j = 0; j < cols; j++) {
                System.out.printf("[%2d%s] ", j + 1, seatChar[i]);
            }
            System.out.println();
            for (int j = 0; j < cols; j++) {
                System.out.printf("   %c  ", seats[i][j] ? 'O' : ' ');
            }
            System.out.println();
        }
    }

    public void printMenu() {
        System.out.println("-".repeat(30));
        System.out.println(" " + title);
        System.out.println("   1. 좌석 예약");
        System.out.println("   2. 예약 취소");
        System.out.println("   3. 예약 현황 조회");
        System.out.println("   4. 메인 메뉴로 돌아가기");
        System.out.println("-".repeat(30));
    }

    public void menu() {
        int choice;

        do {
            printMenu();
            System.out.print("메뉴를 선택해주세요: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("예약할 좌석 번호를 입력하세요: ");
                    String seatName = scanner.next();
                    reserveSeat(seatName);
                    break;
                case 2:
                    System.out.print("취소할 좌석 번호를 입력하세요: ");
                    String cancelSeatName = scanner.next();
                    cancelSeat(cancelSeatName);
                    break;
                case 3:
                    displaySeat(title);
                    break;
                case 4:
                    System.out.println(title + "을 종료하고 메인 메뉴로 돌아갑니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요 (1~4)");
            }
        } while (choice != 4);
    }
}
