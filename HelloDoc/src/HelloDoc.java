/**
 * javadoc 사용 예제
 * @author Buyeon Hwang
 * @version 1.0
 * @since 1.8
 */

public class HelloDoc {
    /**
     * 두 정수의 합을 구하는 메소드
     * @param i: 첫 번째 정수형 인자
     * @param j: 두 번째 정수형 인자
     * @return 두 정수의 합
     */
    public static int sum(int i, int j) {
        return i + j;
    }

    /**
     * main() 메소드
     * @param args args
     */
    public static void main(String[] args) {
        int i;
        int j;

        char a;
        String b;
        final int TEN = 10;

        i = 1;
        j = sum(i, TEN);
        a = '?';
        b = "Hello";

        System.out.println(a);
        System.out.println(b);
        System.out.println(TEN);
        System.out.println(j);

    }
}