public class StringCompare {
    public static void main(String[] args) {
        String str1 = "C++";
        String str2 = "Java";
        String str3 = "java";

        int res = str1.compareTo(str2);
        System.out.println("res: " + res);

        if (res == 0) {
            System.out.println("The same");
        } else if (res < 0) {
            System.out.println(str1 + " < " + str2);
        } else {
            System.out.println(str1 + " > " + str2);
        }

        if (str2.compareToIgnoreCase((str3)) == 0) {
            System.out.println("동일한 문자열");
        } else {
            System.out.println("서로 다른 문자열");
        }
    }
}