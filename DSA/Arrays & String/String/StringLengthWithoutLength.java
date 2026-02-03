import java.util.Scanner;

public class StringLengthWithoutLength {
    static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Reached the end of string
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        int len1 = getLength(text);
        int len2 = text.length();

        System.out.println("Custom method length: " + len1);
        System.out.println("Built-in length: " + len2);
    }
}

