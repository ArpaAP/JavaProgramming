/**
 * 컴퓨터학부 글솝
 * 2024003159 황부연
 * 기말고사 2번
 */

import java.io.IOException;
import java.util.Random;

public class Player extends Thread {
    BingoBoard bingoBoard;

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }

            int row = random.nextInt(5);
            int col = random.nextInt(5);

            bingoBoard.select(Thread.currentThread().getName(), row, col);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public BingoBoard getBingoBoard() {
        return bingoBoard;
    }

    public void setBingoBoard(BingoBoard bingoBoard) {
        this.bingoBoard = bingoBoard;
    }
}
