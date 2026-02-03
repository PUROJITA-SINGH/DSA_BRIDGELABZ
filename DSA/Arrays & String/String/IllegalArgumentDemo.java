import java.util.Scanner;

public class IllegalArgumentDemo {
    static void generateException(String text) {
        System.out.println(text.substring(5, 2)); // Start > end
    }

    static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (StringIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        //generateException(text); // Uncomment to see exception
        handleException(text);
    }
}
