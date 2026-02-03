import java.util.Scanner;

public class CharTypeTable {

    static String charType(char c) {
        if (c >= 'A' && c <= 'Z') c = (char)(c + 32);
        if (c >= 'a' && c <= 'z') {
            if ("aeiou".indexOf(c) != -1) return "Vowel";
            else return "Consonant";
        } else return "Not a Letter";
    }

    static String[][] getCharTypes(String str) {
        String[][] table = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            table[i][0] = String.valueOf(str.charAt(i));
            table[i][1] = charType(str.charAt(i));
        }
        return table;
    }

    static void displayTable(String[][] table) {
        System.out.println("Character\tType");
        for (int i = 0; i < table.length; i++)
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] table = getCharTypes(text);
        displayTable(table);
    }
}

