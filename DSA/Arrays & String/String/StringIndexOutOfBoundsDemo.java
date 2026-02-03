import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    static void generateException(String text) {
        System.out.println(text.charAt(text.length())); // Out of bounds
    }

    static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        //generateException(text); // Uncomment to see the exception
        handleException(text);
    }
}

