import java.util.Scanner;

public class PalindromeCheck {

    static boolean isPalindromeIterative(String str) {
        int start = 0, end = str.length()-1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start+1, end-1);
    }

    static boolean isPalindromeReverseArray(String str) {
        char[] arr = str.toCharArray();
        char[] rev = new char[arr.length];
        for (int i = 0; i < arr.length; i++) rev[i] = str.charAt(arr.length-1-i);
        for (int i = 0; i < arr.length; i++) if (arr[i] != rev[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " + isPalindromeIterative(text));
        System.out.println("Recursive: " + isPalindromeRecursive(text, 0, text.length()-1));
        System.out.println("Reverse Array: " + isPalindromeReverseArray(text));
    }
}

