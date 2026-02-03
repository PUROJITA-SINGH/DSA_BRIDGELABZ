import java.util.Scanner;

public class UniqueCharacters {
    static int getLength(String str) {
        int count = 0;
        try {
            while (true) { str.charAt(count); count++; }
        } catch (IndexOutOfBoundsException e) {}
        return count;
    }

    static char[] uniqueCharacters(String str) {
        int len = getLength(str);
        char[] temp = new char[len];
        int count = 0;

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            boolean unique = true;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == c) { unique = false; break; }
            }
            if (unique) temp[count++] = c;
        }

        char[] unique = new char[count];
        for (int i = 0; i < count; i++) unique[i] = temp[i];
        return unique;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char[] unique = uniqueCharacters(text);
        System.out.print("Unique characters: ");
        for (char c : unique) System.out.print(c + " ");
    }
}

