import java.util.Scanner;

public class CharFrequencyASCII {
    static String[][] charFrequency(String str) {
        int[] freq = new int[256];
        int len = str.length();

        for (int i = 0; i < len; i++) freq[str.charAt(i)]++;

        int count = 0;
        for (int i = 0; i < 256; i++) if (freq[i] > 0) count++;

        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = Character.toString((char)i);
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

