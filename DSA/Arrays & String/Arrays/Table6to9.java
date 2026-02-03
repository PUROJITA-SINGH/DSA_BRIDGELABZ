import java.util.Scanner;

public class Table6to9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] result = new int[4];

        for (int i = 6; i <= 9; i++) {
            result[i - 6] = num * i;
            System.out.println(num + " * " + i + " = " + result[i - 6]);
        }
    }
}
