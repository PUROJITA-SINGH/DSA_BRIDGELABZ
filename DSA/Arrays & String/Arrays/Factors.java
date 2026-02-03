import java.util.Scanner;

public class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int max = 10, index = 0;
        int[] factors = new int[max];

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                if (index == max) {
                    max *= 2;
                    int[] temp = new int[max];
                    System.arraycopy(factors, 0, temp, 0, index);
                    factors = temp;
                }
                factors[index++] = i;
            }
        }

        for (int i = 0; i < index; i++)
            System.out.print(factors[i] + " ");
    }
}
