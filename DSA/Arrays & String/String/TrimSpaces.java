import java.util.Scanner;

public class TrimSpaces {

    static int[] findTrimIndexes(String str) {
        int start = 0, end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' ') start++;
        while (end >= start && str.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    static String substringCharAt(String str, int start, int end) {
        String sub = "";
        for (int i = start; i <= end; i++) sub += str.charAt(i);
        return sub;
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String text = sc.nextLine();

        int[] indexes = findTrimIndexes(text);
        String trimmedCustom = substringCharAt(text, indexes[0], indexes[1]);
        String trimmedBuiltIn = text.trim();

        System.out.println("Custom trim: [" + trimmedCustom + "]");
        System.out.println("Built-in trim: [" + trimmedBuiltIn + "]");
        System.out.println("Are they equal? " + compareStrings(trimmedCustom, trimmedBuiltIn));
    }
}

