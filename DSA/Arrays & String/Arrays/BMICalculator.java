import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Number of persons
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        // b. Arrays
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        // c. Input weight and height
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("Enter weight (kg): ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter height (meters): ");
            height[i] = sc.nextDouble();
        }

        // d. Calculate BMI and status
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4)
                status[i] = "Underweight";
            else if (bmi[i] <= 24.9)
                status[i] = "Normal";
            else if (bmi[i] <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        // e. Display result
        System.out.println("\nHeight  Weight  BMI   Status");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f   %.2f   %.2f   %s\n",
                    height[i], weight[i], bmi[i], status[i]);
        }
    }
}
