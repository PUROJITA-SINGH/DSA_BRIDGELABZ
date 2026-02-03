import java.util.Scanner;

public class ToLowerExample {
    static String toLowerCharAt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char)(c + 32); // Convert to lowercase
            }
            result += c;
        }
        return result;
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String lower1 = toLowerCharAt(text);
        String lower2 = text.toLowerCase();

        System.out.println("Custom method: " + lower1);
        System.out.println("Built-in method: " + lower2);
        System.out.println("Are they equal? " + compareStrings(lower1, lower2));
    }
}

