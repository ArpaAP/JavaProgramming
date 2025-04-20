/**
 * 컴퓨터학부 글솝
 * 2024003159 황부연
 * 중간고사 1번
 */

import java.util.Random;
import java.util.Scanner;

public class DiceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int trials;

        while (true) {
            System.out.print("주사위를 던질 회수를 입력하세요(>=10): ");
            trials = scanner.nextInt();

            if (trials >= 10) break;

            System.out.println("[입력 오류] 다시 숫자를 입력하세요!");
        }

        int[][] counts = new int[6][6];
        int[] sums = new int[12];

        Random random = new Random();

        for (int i = 0; i < trials; i++) {
            int a = random.nextInt(6) + 1;
            int b = random.nextInt(6) + 1;
            int s = a + b;

            System.out.printf("(%d+%d)=%2d", a, b, s);

            if (i % 5 == 4 || i == trials - 1) {
                System.out.println();
            } else {
                System.out.print(", ");
            }

            counts[a - 1][b - 1]++;
            sums[s - 1]++;
        }

        System.out.println("\n[주사위 숫자별 빈도수]");

        System.out.print(" ".repeat(3));
        for (int i = 0; i < 6; i++) {
            System.out.printf("%2d ", i + 1);
        }
        System.out.println("\n" + " ".repeat(3) + "-".repeat(18));

        for (int i = 0; i < 6; i++) {
            System.out.printf("%2d|", i + 1);

            for (int j = 0; j < 6; j++) {
                System.out.printf("%2d ", counts[i][j]);
            }
            System.out.println();
        }

        System.out.println("-".repeat(32));

        System.out.println("\n[주사위 합의 빈도수]");

        for (int i = 1; i < 12; i++) {
            System.out.printf("%2d ", i + 1);
        }
        System.out.println("\n" + "-".repeat(32));

        for (int i = 1; i < 12; i++) {
            System.out.printf("%2d ", sums[i]);
        }
        System.out.println("\n" + "-".repeat(32));

        scanner.close();
    }
}