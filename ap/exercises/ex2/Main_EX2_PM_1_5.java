package ap.exercises.ex2;

import java.util.Scanner;
import java.util.Random;

public class Main_EX2_PM_1_5 {
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
        int pacx = 1;
        int pacy = 1;
        array[pacx][pacy] = "X";
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        int d = 0;
        Random rnd = new Random();
        do {
            d = rnd.nextInt(4);
            int newx = pacx + directions[d][0];
            int newy = pacy + directions[d][1];
            if (newx >= 0 && newx < k + 2 && newy >= 0 && newy < k + 2) {
                if (array[newx][newy].equals(" ")) {
                    array[pacx][pacy] = " ";
                    pacx = newx;
                    pacy = newy;
                    array[pacx][pacy] = "X";
                    for (int i = 0; i < k + 2; i++) {
                        for (int j = 0; j < k + 2; j++) {
                            System.out.print(array[i][j]);
                        }
                        System.out.println();
                    }
                } else if (array[newx][newy].equals("*")) {
                    System.out.println("hitting the game wall");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        } while (d<4);
    }
}
