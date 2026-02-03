import java.util.Scanner;
import java.util.Random;

public class VotingEligibility {
    static int[] generateAges(int n) {
        Random r = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) ages[i] = r.nextInt(100); // 0 to 99
        return ages;
    }

    static String[][] checkEligibility(int[] ages) {
        String[][] table = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            table[i][0] = String.valueOf(ages[i]);
            table[i][1] = (ages[i] >= 18) ? "true" : "false";
        }
        return table;
    }

    static void displayTable(String[][] table) {
        System.out.println("Age\tCan Vote");
        for (int i = 0; i < table.length; i++)
            System.out.println(table[i][0] + "\t" + table[i][1]);
    }

    public static void main(String[] args) {
        int[] ages = generateAges(10);
        String[][] table = checkEligibility(ages);
        displayTable(table);
    }
}

