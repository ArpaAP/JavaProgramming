/**
 * 컴퓨터학부 글솝
 * 2024003159 황부연
 * 중간고사 2번
 */

import java.util.Scanner;

public class StringUtilApp {
    public static final String text = "Betty Botter bought some butter, but she said this butter’s bitter. "
            + "If I put it in my batter, it will make my batter bitter.\n"
            + "So, she bought some better butter, better than the bitter butter,"
            + " and she put it in her batter, and her batter was not bitter.\n";

    public static void printMenu() {
        System.out.println("-".repeat(42));
        System.out.println(" 1. Search a word and display all indexes");
        System.out.println(" 2. Replace a word one by one");
        System.out.println(" 0. Quit");
        System.out.println("-".repeat(42));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringUtil stringUtil = new StringUtil(text);

        while (true) {
            printMenu();

            System.out.print("Choose a number: ");

            int menu = scanner.nextInt();

            if (menu == 0) {
                System.out.println("Quit Program");
                break;
            } else if (menu == 1) {
                System.out.print("Type a search word: ");
                String search = scanner.next();

                stringUtil.printAllIndex(search);
            } else if (menu == 2) {
                System.out.print("Type two words(searchword, replacement): ");
                String target = scanner.next();
                String replacement = scanner.next();

                stringUtil.replaceText(target, replacement);
            } else {
                System.out.println("Wrong Menu. Type again!");
            }
        }
    }
}