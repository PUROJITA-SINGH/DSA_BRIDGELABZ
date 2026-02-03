import java.util.Scanner;

public class CharFrequencyUnique {
    static char[] uniqueCharacters(String str) {
        int len = str.length();
        char[] temp = new char[len];
        int count = 0;

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            boolean unique = true;
            for (int j = 0; j < i; j++) if (str.charAt(j) == c) { unique = false; break; }
            if (unique) temp[count++] = c;
        }

        char[] unique = new char[count];
        for (int i = 0; i < count; i++) unique[i] = temp[i];
        return unique;
    }

    static String[][] charFrequency(String str) {
        char[] unique = uniqueCharacters(str);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) if (str.charAt(j) == unique[i]) count++;
            result[i][0] = Character.toString(unique[i]);
            result[i][1] = String.valueOf(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] freqTable = charFrequency(text);
        System.out.println("Character\tFrequency");
        for (String[] row : freqTable) System.out.println(row[0] + "\t\t" + row[1]);
    }
}

