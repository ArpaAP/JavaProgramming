/**
 * 컴퓨터학부 글로벌소프트웨어융합전공
 * 2024003159 황부연
 * 2025년 4월 22일
 * 과제05,06 - 통합예약
 */

import java.util.Scanner;

public class BusSystem extends ReservationSystem {
    public BusSystem(String title, Scanner scanner) {
        super(title, scanner, 3, 10, 1);

        for (int i = 0; i < rows; i++) {
            seatChar[i] = (char) ('C' - i);
        }
    }
}
