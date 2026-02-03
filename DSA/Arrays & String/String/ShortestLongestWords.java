import java.util.Scanner;

public class ShortestLongestWords {
    static int getLength(String str) {
        int count = 0;
        try { while (true) { str.charAt(count); count++; } } 
        catch (IndexOutOfBoundsException e) {}
        return count;
    }

    static String[] splitWords(String str) {
        int len = getLength(str);
        int wordCount = 1;
        for (int i = 0; i < len; i++) if (str.charAt(i) == ' ') wordCount++;
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

    static String[][] wordsAndLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    static String[] findShortestLongest(String[][] arr) {
        int minLen = Integer.parseInt(arr[0][1]);
        int maxLen = Integer.parseInt(arr[0][1]);
        String shortest = arr[0][0], longest = arr[0][0];

        for (int i = 1; i < arr.length; i++) {
            int len = Integer.parseInt(arr[i][1]);
            if (len < minLen) { minLen = len; shortest = arr[i][0]; }
            if (len > maxLen) { maxLen = len; longest = arr[i][0]; }
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] table = wordsAndLengths(words);
        String[] result = findShortestLongest(table);

        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);
    }
}

