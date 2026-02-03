import java.util.Scanner;

public class FirstNonRepeatingChar {
    static char firstNonRepeating(String str) {
        int[] freq = new int[256];
        int len = str.length();

        for (int i = 0; i < len; i++) freq[str.charAt(i)]++;

        for (int i = 0; i < len; i++) {
            if (freq[str.charAt(i)] == 1) return str.charAt(i);
        }
        return '\0'; // no non-repeating character
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char result = firstNonRepeating(text);
        if (result != '\0') System.out.println("First non-repeating character: " + result);
        else System.out.println("No non-repeating character found.");
    }
}

