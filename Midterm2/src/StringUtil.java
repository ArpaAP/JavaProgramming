/**
 * 컴퓨터학부 글솝
 * 2024003159 황부연
 * 중간고사 2번
 */

public class StringUtil {
    public String text;

    public StringUtil(String text) {
        this.text = text;
    }

    public void printAllIndex(String search) {
        if (!text.contains(search)) {
            System.out.println(search + " is not found!\n");
            return;
        }

        int idx = -1;

        System.out.print("[");
        while (true) {
            idx = text.indexOf(search, idx + 1);

            if (idx < 0) break;

            System.out.printf("%d, ", idx);
        }
        System.out.println("]");
    }

    public void replaceText(String target, String replacement) {
        int idx = -1;
        int count = 0;

        while (true) {
            idx = text.indexOf(target, idx + 1);

            if (idx == -1) break;
            count++;
        }

        if (count == 0) {
            System.out.println(target + " is not found!\n");
            return;
        }

        System.out.printf("[%s] was fount %d times.\n", target, count);

        System.out.println("-".repeat(48));

        System.out.println("Original Text");
        System.out.println(text);

        for (int i = 0; i < count; i++) {
            System.out.printf("Replaced Text [%d] %s -> %s\n", i + 1, target, replacement);
            System.out.println("-".repeat(48));

            idx = text.indexOf(target);
            String front = text.substring(0, idx);
            String last = text.substring(idx + target.length());

            text = front + replacement + last;
            System.out.println(text);
        }
    }
}
