import java.util.Scanner;

public class BMIProgram {
    static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightM = data[i][1] / 100; // convert cm to meters
            double bmi = weight / (heightM * heightM);
            String status;
            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 24.9) status = "Normal";
            else if (bmi < 29.9) status = "Overweight";
            else status = "Obese";

            result[i][0] = String.valueOf(weight);
            result[i][1] = String.valueOf(data[i][1]);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        return result;
    }

    static void displayBMI(String[][] data) {
        System.out.println("Weight(kg)\tHeight(cm)\tBMI\tStatus");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1] + "\t\t" + data[i][2] + "\t" + data[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] members = new double[10][2]; // 10 members: weight and height

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i+1) + ": ");
            members[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i+1) + ": ");
            members[i][1] = sc.nextDouble();
        }

        String[][] bmiData = calculateBMI(members);
        displayBMI(bmiData);
    }
}
