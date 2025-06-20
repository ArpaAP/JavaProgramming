/**
 * 컴퓨터학부 글솝
 * 2024003159 황부연
 * 기말고사 2번
 */

import java.io.IOException;
import java.io.Writer;

public class BingoBoard {
    public final static int maxRows = 5;
    public final static int maxCols = 5;

    public Writer writer;
    public int[][] gameBoard;
    public String[][] selectionBoard;
    public int selectionCount;

    Player p1;
    Player p2;

    public int p1Count = 0;
    public int p2Count = 0;

    public BingoBoard(int[][] gameBoard, Writer writer, Player p1, Player p2) {
        this.gameBoard = gameBoard;
        this.selectionBoard = new String[maxRows][maxCols];
        this.selectionCount = 0;
        this.writer = writer;

        this.p1 = p1;
        this.p2 = p2;
    }

    public synchronized void select(String threadName, int r, int c) {
        if (selectionBoard[r][c] != null) {
            System.out.printf("Player %s: [%d][%d]=%d => occupied.\n", threadName, r, c, gameBoard[r][c]);
            drawBingoBoard();
            return;
        }

        String output = String.format("Player %s: [%d][%d]=%d => success.\n", threadName, r, c, gameBoard[r][c]);
        System.out.print(output);
        try {
            writer.write(output);
        } catch (IOException e) {}

        selectionBoard[r][c] = threadName;
        selectionCount++;

        if (threadName.equals("p1")) {
            p1Count++;
        } else if (threadName.equals("p2")) {
            p2Count++;
        }

        drawBingoBoard();

        if (selectionCount == 25) {
            p1.interrupt();
            p2.interrupt();
        }
    }

    public void drawBingoBoard() {
        System.out.println("         Random Bingo                     Player Choice         ");
        System.out.println("+-----------------------------+  +-----------------------------+");
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {

                System.out.printf("| %3d ", gameBoard[i][j]);
            }
            System.out.print("|  ");

            for (int j = 0; j < maxCols; j++) {

                System.out.printf("| %3d ", gameBoard[i][j]);
            }
            System.out.println("|");

            for (int k = 0; k < maxCols; k++) {
                String name = selectionBoard[i][k];
                System.out.printf("|(%3s)", name == null ? "" : name);
            }
            System.out.print("|  ");

            //반복
            for (int k = 0; k < maxCols; k++) {
                String name = selectionBoard[i][k];

                if (name == null)
                    System.out.printf("| %3s ", " ");
                else
                    System.out.printf("| %3s ", name.equals("p1") ? "O" : "X");

            }
            System.out.println("|");
            System.out.println("+-----------------------------+  +-----------------------------+");
        }

    }
}
