/**
 * 컴퓨터학부 글로벌소프트웨어융합전공
 * 2024003159 황부연
 * 2025년 3월 21일
 * 과제02 - 로또생성
 */

import java.util.Arrays;
import java.util.Scanner;

public class MultipleLottoGames {
    static int LOTTO_NUM = 6;

    /**
     * 중복 없는 정렬된 로또 번호를 생성
     * @return 로또 번호 배열
     */
    public static int[] generateLottoNumbers() {
        int[] lottoGame = new int[LOTTO_NUM];

        for (int i = 0; i < LOTTO_NUM; i++) {
            boolean isDuplicate = false;
            int num = (int)(Math.random() * 44 + 1);

            for (int j = 0; j < i; j++) {
                if (num == lottoGame[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                lottoGame[i] = num;
            } else {
                i--;
            }
        }

        Arrays.sort(lottoGame);

        return lottoGame;
    }

    /**
     * 로또 번호 배열을 자리 수 맞추어 출력
     * @param lottoGame 로또 번호 배열
     */
    public static void printLottoNumbers(int[] lottoGame) {
        for (int i = 0; i < LOTTO_NUM; i++) {
            System.out.printf("%4d", lottoGame[i]);
        }
        System.out.println();
    }

    /**
     * 로또 번호 당첨 비교
     * @param lotto 비교 대상 로또 번호
     * @param winningLotto 당첨 번호
     */
    public static void compareLottoNumbers(int[] lotto, int[] winningLotto) {
        printLottoNumbers(lotto);

        System.out.print("         ");

        for (int i = 0; i < LOTTO_NUM; i++) {
            boolean isWinning = false;

            for (int j = 0; j < LOTTO_NUM; j++) {
                if (lotto[i] == winningLotto[j]) {
                    isWinning = true;
                    break;
                }
            }

            if (isWinning) {
                System.out.print("   O");
            }
            else {
                System.out.print("   X");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] winningLotto = new int[LOTTO_NUM];
        int [][] randomLotto;
        int gameCount;

        do {
            System.out.print("구입할 Lotto 수를 입력하세요 (1~5): ");
            gameCount = scanner.nextInt();
        } while (1 > gameCount || gameCount > 5);

        System.out.println("----------------------------------------");

        randomLotto = new int[gameCount][LOTTO_NUM];

        for (int i = 0; i < gameCount; i++) {
            randomLotto[i] = generateLottoNumbers();
        }

        System.out.println("자동 생성 로또 번호");

        for (int i = 0; i < gameCount; i++) {
            System.out.printf("[%2d]", i);
            printLottoNumbers(randomLotto[i]);
        }

        System.out.println("----------------------------------------");

        winningLotto = generateLottoNumbers();

        System.out.print("당첨 번호:  ");
        printLottoNumbers(winningLotto);

        System.out.println("----------------------------------------");

        for (int i = 0; i < gameCount; i++) {
            System.out.printf("당첨결과[%d]:", i + 1);
            compareLottoNumbers(randomLotto[i], winningLotto);
            System.out.println("----------------------------------------");
        }

        System.out.println("Lotto 게임 종료");
    }
}
