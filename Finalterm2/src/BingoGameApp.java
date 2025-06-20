/**
 * 컴퓨터학부 글솝
 * 2024003159 황부연
 * 기말고사 2번
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;

public class BingoGameApp {
    public static int[][] gameBoard = new int[5][5];

    public static void main(String[] args) {
        ArrayList<Integer> randNums = new ArrayList<>();

        try {
            Writer writer = new FileWriter("bingo.txt");

            for (int i = 0; i < 25; i++) {
                randNums.add(i + 1);
            }

            Collections.shuffle(randNums);

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    gameBoard[i][j] = randNums.get(i * 5 + j);
                }
            }

            Player p1 = new Player();
            Player p2 = new Player();

            BingoBoard bingoBoard = new BingoBoard(gameBoard, writer, p1, p2);

            p1.setName("p1");
            p1.setBingoBoard(bingoBoard);

            p2.setName("p2");
            p2.setBingoBoard(bingoBoard);

            p1.start();
            p2.start();

            p1.join();
            System.out.printf("Thread p1 finished (Bingo count: %d)\n", bingoBoard.p1Count);

            p2.join();
            System.out.printf("Thread p2 finished (Bingo count: %d)\n", bingoBoard.p2Count);

            System.out.println("Game End");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {}
    }
}