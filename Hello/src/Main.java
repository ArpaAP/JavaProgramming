import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("원하는 내용을 입력하세요: ");
        input = scanner.nextLine();
        System.out.println("입력 내용" + input);

        scanner.close();
        System.out.println("프로그램 종료");
    }
}