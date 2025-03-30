public class SplitExample2 {
    public static void main(String[] args) {
        String str1 = "boo:and:foo";
        String[] splited1 = str1.split(":");

        for (String s : splited1) {
            System.out.println(s);
        }
        System.out.println();

        String str2 = "aaa bbb ccc";
        String[] splited2 = str2.split(" ");
        for (String s : splited2) {
            System.out.println(s);
        }
        System.out.println();

        String str3 = "Hello,world;Java Programming";
        String[] splited3 = str3.split("[,; ]");
        for (String s : splited3) {
            System.out.println(s);
        }
        System.out.println();
    }
}
