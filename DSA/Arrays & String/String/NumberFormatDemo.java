import java.util.Scanner;

public class NumberFormatDemo {
    static void generateException(String text) {
        int num = Integer.parseInt(text); // Throws exception if not a number
        System.out.println(num);
    }

    static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string number: ");
        String text = sc.next();

        //generateException(text); // Uncomment to see exception
        handleException(text);
    }
}

