package ap.exercises.ex2;

import java.util.Scanner;
import java.util.Random;

public class Main_EX2_PM_1_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
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
        int count1;
        do{
            System.out.println("Enter the count of . :");
            count1 = input.nextInt();
        }while (count1>k*k);
        for (int i = 0; i < count1; i++) {
            int x = 1 + rnd.nextInt(k);
            int y = 1 + rnd.nextInt(k);
            if(array[x][y].equals(" ")){
                array[x][y] = ".";
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
