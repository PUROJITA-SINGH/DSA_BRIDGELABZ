import java.util.Scanner;

public class ToUpperExample {
    static String toUpperCharAt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 32); // Convert to uppercase
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

        String upper1 = toUpperCharAt(text);
        String upper2 = text.toUpperCase();

        System.out.println("Custom method: " + upper1);
        System.out.println("Built-in method: " + upper2);
        System.out.println("Are they equal? " + compareStrings(upper1, upper2));
    }
}

