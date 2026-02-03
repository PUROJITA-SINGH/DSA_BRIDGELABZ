import java.util.Scanner;

public class SplitTextWithoutSplit {

    static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return count;
    }

    static String[] splitWords(String str) {
        int len = getLength(str);
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') wordCount++;
        }
        String[] words = new String[wordCount];
        int start = 0, w = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || str.charAt(i) == ' ') {
                String word = "";
                for (int j = start; j < i; j++) word += str.charAt(j);
                words[w++] = word;
                start = i + 1;
            }
        }
        return words;
    }

    static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words1 = splitWords(text);
        String[] words2 = text.split(" ");

        System.out.println("Custom split: " + java.util.Arrays.toString(words1));
        System.out.println("Built-in split: " + java.util.Arrays.toString(words2));
        System.out.println("Are they equal? " + compareArrays(words1, words2));
    }
}

