import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int a = switch(s) {
            case "A":
                yield 1;
            case "B":
                yield 2;
            default:
                yield 0;
        };
    }
}