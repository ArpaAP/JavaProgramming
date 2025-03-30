/**
 * 컴퓨터학부 글로벌소프트웨어융합전공
 * 2024003159 황부연
 * 2025년 3월 26일
 * 과제03 - 경주게임
 */

import java.util.Random;

public class Race {
    final static int RACE_SIZE = 50;

    int tortoisePosition;
    int harePosition;
    String tortoiseMoveType;
    String hareMoveType;

    public Race() {
        tortoisePosition = 0;
        harePosition = 0;
    }

    /**
     * 랜덤 숫자 생성
     * @return
     */
    public int getRandomNumber() {
        Random random = new Random();

        return random.nextInt(10) + 1;
    }

    /**
     * 거북이와 위치를 50이하 범위로 출력
     * @return
     */
    public int getDisplayTortoisePosition() {
        return Math.min(RACE_SIZE, tortoisePosition);
    }

    /**
     * 토끼와 위치를 50이하 범위로 출력
     * @return
     */
    public int getDisplayHarePosition() {
        return Math.min(RACE_SIZE, harePosition);
    }

    /**
     * 경주를 출력
     */
    public void printRace() {
        int displayTortoisePosition = getDisplayTortoisePosition();
        int displayHarePosition = getDisplayHarePosition();

        System.out.print(" ".repeat(displayTortoisePosition));
        System.out.printf("T(%d:%s)\n", displayTortoisePosition, tortoiseMoveType);
        System.out.print(" ".repeat(displayHarePosition));
        System.out.printf("H(%d:%s)\n", displayHarePosition, hareMoveType);
        System.out.println("-".repeat(RACE_SIZE));
    }

    /**
     * 거북이의 위치를 이동
     */
    public void moveTortoise() {
        int num = getRandomNumber();

        switch (num) {
            case 1, 2, 3, 4, 5 -> {
                tortoiseMoveType = "Fast Walk";
                tortoisePosition += 3;
            }
            case 6, 7 -> {
                tortoiseMoveType = "Slip";
                tortoisePosition -= 6;
            }
            case 8, 9, 10 -> {
                tortoiseMoveType = "Slow Walk";
                tortoisePosition += 1;
            }
        }

        tortoisePosition = Math.max(0, tortoisePosition);
    }

    /**
     * 토끼의 위치를 이동
     */
    public void moveHare() {
        int num = getRandomNumber();

        switch (num) {
            case 1, 2 -> {
                hareMoveType = "Sleep";
            }
            case 3, 4 -> {
                hareMoveType = "Big Hop";
                harePosition += 9;
            }
            case 5 -> {
                hareMoveType = "Big Slip";
                harePosition -= 12;
            }
            case 6, 7, 8 -> {
                hareMoveType = "Small Hop";
                harePosition += 1;
            }
            case 9, 10 -> {
                hareMoveType = "Small Slip";
                harePosition -= 2;
            }
        }

        harePosition = Math.max(0, harePosition);
    }

    /**
     * 경주가 끝났는지 확인
     * @return
     */
    public boolean isEnd() {
        return Math.max(tortoisePosition, harePosition) >= RACE_SIZE;
    }

}
