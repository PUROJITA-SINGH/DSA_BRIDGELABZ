import java.util.Scanner;

public class WordsWithLengths {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] table = wordsAndLengths(words);

        System.out.println("Word\tLength");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + Integer.parseInt(table[i][1]));
        }
    }
}

