package exercises.ex2;
import java.util.Scanner;

public class Main_EX2_PM_1_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number");
        int k = input.nextInt();
        for (int i=0; i<k+2; i++) {
            if (i == 0 || i == k + 1) {
                for (int j = 0; j < k + 2; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j < k + 2; j++) {
                    if (j == 0 || j == k + 1) {
                        System.out.print("*");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
    }
}
