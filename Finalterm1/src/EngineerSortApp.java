/**
 * 컴퓨터학부 글솝
 * 2024003159 황부연
 * 기말고사 1번
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EngineerSortApp {
    public static void printMenu() {
        System.out.println("=".repeat(68));
        System.out.println("1. Print the list sorted by first name and last name (ascending)");
        System.out.println("2. Print the list sorted by salary and first name (descending)");
        System.out.println("3. Print the list sorted by working years (ascending)");
        System.out.println("4. Change the salary of an engineer then sort by salary (descending)");
        System.out.println("5. Quit");
        System.out.println("=".repeat(68));
    }

    public static void main(String[] argv) {
        ArrayList<Engineer> engineers = new ArrayList<>();

        engineers.add(new Engineer("Bob", "Lewis", 350, 2));
        engineers.add(new Engineer("John", "Smith", 300, 1));
        engineers.add(new Engineer("Dennis", "Richie", 900, 12));
        engineers.add(new Engineer("John", "Lee", 650, 6));
        engineers.add(new Engineer("Marry", "Anne", 650, 8));
        engineers.add(new Engineer("Lisa", "Barnes", 450, 5));

        System.out.println("[Unsorted Engineer List]");
        EngineerSort.printEngineers(engineers);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("-> ");

            int num = scanner.nextInt();

            switch (num) {
                case 1 -> {
                    EngineerSort.printSorted1(engineers);
                }
                case 2 -> {
                    EngineerSort.printSorted2(engineers);
                }
                case 3 -> {
                    EngineerSort.printSorted3(engineers);
                }
                case 4 -> {
                    System.out.print("Type lastname: ");
                    String lastName = scanner.next();

                    Engineer found = null;
                    for (Engineer e : engineers) {
                        if (e.lastName.equals(lastName)) {
                            found = e;
                            break;
                        }
                    }

                    if (found == null) {
                        System.out.println(lastName + " is not found");
                        break;
                    }

                    EngineerSort.printEngineers(List.of(found));

                    System.out.print("Type new salary: ");

                    found.salary = scanner.nextInt();

                    EngineerSort.printSorted4(engineers);
                }
                case 5 -> {
                    System.out.println("Exit Program");
                    scanner.close();
                    return;
                }
            }
        }
    }
}
