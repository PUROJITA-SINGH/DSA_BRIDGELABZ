import java.util.Scanner;

public class BMI2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Number of persons
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        // b. 2D array: [weight, height, BMI]
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // c. Input weight and height
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));

            System.out.print("Enter weight: ");
            personData[i][0] = sc.nextDouble();

            System.out.print("Enter height: ");
            personData[i][1] = sc.nextDouble();

            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.out.println("Enter positive values only");
                i--;
            }
        }

        // d. Calculate BMI and status
        for (int i = 0; i < number; i++) {
            personData[i][2] =
                    personData[i][0] / (personData[i][1] * personData[i][1]);

            if (personData[i][2] <= 18.4)
                weightStatus[i] = "Underweight";
            else if (personData[i][2] <= 24.9)
                weightStatus[i] = "Normal";
            else if (personData[i][2] <= 39.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        // e. Display result
        System.out.println("\nWeight  Height  BMI   Status");
        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f  %.2f  %.2f  %s\n",
                    personData[i][0],
                    personData[i][1],
                    personData[i][2],
                    weightStatus[i]);
        }
    }
}
