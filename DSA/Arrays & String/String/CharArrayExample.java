import java.util.Scanner;

public class CharArrayExample {
    static char[] getChars(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] arr1 = getChars(text);
        char[] arr2 = text.toCharArray();

        System.out.println("Custom method array: " + java.util.Arrays.toString(arr1));
        System.out.println("Built-in toCharArray() array: " + java.util.Arrays.toString(arr2));
        System.out.println("Arrays equal? " + compareCharArrays(arr1, arr2));
    }
}

