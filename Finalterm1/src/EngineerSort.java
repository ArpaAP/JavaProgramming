/**
 * 컴퓨터학부 글솝
 * 2024003159 황부연
 * 기말고사 1번
 */

import java.util.Comparator;
import java.util.List;

public class EngineerSort {
    public static void printEngineers(List<Engineer> engineers) {
        String line = "+" + "-".repeat(12) + "+" + "-".repeat(11) + "+" + "-".repeat(8) + "+" + "-".repeat(15) + "+";
        System.out.println(line);
        System.out.println("| First name | Last name | Salary | Working Years |");
        System.out.println(line);

        for (Engineer e : engineers) {
            System.out.printf("| %10s | %9s | %6d | %13d |\n", e.firstName, e.lastName, e.salary, e.workingYears);
        }

        System.out.println(line);
    }

    public static void printSorted1(List<Engineer> engineers) {
        engineers.sort(new Comparator<Engineer>() {
            @Override
            public int compare(Engineer o1, Engineer o2) {
                int firstCompare = o1.firstName.compareTo(o2.firstName);

                if (firstCompare == 0) {
                    return o1.lastName.compareTo(o2.lastName);
                }

                return firstCompare;
            }
        });

        System.out.println("[Sort by first name and last name]");
        printEngineers(engineers);
    }

    public static void printSorted2(List<Engineer> engineers) {
        engineers.sort(new Comparator<Engineer>() {
            @Override
            public int compare(Engineer o1, Engineer o2) {
                int firstCompare = o2.salary - o1.salary;

                if (firstCompare == 0) {
                    return o2.firstName.compareTo(o1.firstName);
                }

                return firstCompare;
            }
        });

        System.out.println("[Sort by salary and first name]");
        printEngineers(engineers);
    }

    public static void printSorted3(List<Engineer> engineers) {
        engineers.sort(new Comparator<Engineer>() {
            @Override
            public int compare(Engineer o1, Engineer o2) {
                return o1.workingYears - o2.workingYears;
            }
        });

        System.out.println("[Sort by working years]");
        printEngineers(engineers);
    }

    public static void printSorted4(List<Engineer> engineers) {
        System.out.println("[Sort by salary]");
        printSorted2(engineers);
    }
}
