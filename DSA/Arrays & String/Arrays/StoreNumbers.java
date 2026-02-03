import java.util.Scanner;

public class StoreNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        double sum = 0;
        int index = 0;

        while (true) {
            double n = sc.nextDouble();
            if (n <= 0 || index == 10)
                break;

            arr[index++] = n;
        }

        for (int i = 0; i < index; i++)
            sum += arr[i];

        System.out.println("Sum = " + sum);
    }
}
