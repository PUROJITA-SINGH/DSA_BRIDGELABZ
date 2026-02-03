import java.util.Scanner;

public class CharFrequencyNested {
    static String[][] charFrequency(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] freq = new int[len];

        for (int i = 0; i < len; i++) {
            if (chars[i] == '0') continue;
            freq[i] = 1;
            for (int j = i+1; j < len; j++) {
                if (chars[i] == chars[j]) { freq[i]++; chars[j] = '0'; }
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) if (chars[i] != '0') count++;

        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                result[index][0] = Character.toString(chars[i]);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
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
