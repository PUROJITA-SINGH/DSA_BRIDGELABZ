import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Input number
        int num = sc.nextInt();
        int temp = num;

        // b. Count digits
        int count = 0;
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        // c. Store digits
        int[] digits = new int[count];
        temp = num;

        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // d. Frequency array
        int[] freq = new int[10];
        for (int i = 0; i < count; i++) {
            freq[digits[i]]++;
        }

        // e. Display frequency
        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0)
                System.out.println(i + " : " + freq[i]);
        }
    }
}

