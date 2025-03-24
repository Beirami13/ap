package exercises.ex2;
import java.util.Scanner;

public class Main_EX2_PM_1_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int k = input.nextInt();
        String[][] array = new String[k + 2][k + 2];
        for (int i = 0; i < k + 2; i++) {
            if (i == 0 || i == k + 1) {
                for (int j = 0; j < k + 2; j++) {
                    array[i][j] = "*";
                }
            } else {
                for (int j = 0; j < k + 2; j++) {
                    if (j == 0 || j == k + 1) {
                        array[i][j] = "*";
                    } else {
                        array[i][j] = " ";
                    }
                }
            }
        }
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
