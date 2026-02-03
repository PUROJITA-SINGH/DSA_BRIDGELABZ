import java.util.Scanner;

public class StudentGrade2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // b. 2D array for marks
        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // c. Input marks
        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Student " + (i + 1));
            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextInt();
                if (marks[i][j] < 0) {
                    System.out.println("Enter positive marks");
                    j--;
                }
            }
        }

        // d. Calculate percentage & grade
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80)
                grade[i] = 'A';
            else if (percentage[i] >= 70)
                grade[i] = 'B';
            else if (percentage[i] >= 60)
                grade[i] = 'C';
            else if (percentage[i] >= 50)
                grade[i] = 'D';
            else if (percentage[i] >= 40)
                grade[i] = 'E';
            else
                grade[i] = 'R';
        }

        // e. Display result
        System.out.println("\nPercentage   Grade");
        for (int i = 0; i < n; i++) {
            System.out.println(percentage[i] + "        " + grade[i]);
        }
    }
}

