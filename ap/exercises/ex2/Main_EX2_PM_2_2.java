package ap.exercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_2_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        // The square wall
        int score = 0;
        System.out.println("Enter a number:");
        int k = input.nextInt();
        String[][] array = new String[k + 2][k + 2];
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                if (i == 0 || i == k + 1 || j == 0 || j == k + 1) {
                    array[i][j] = "*";
                } else {
                    array[i][j] = " ";
                }
            }
        }
        // The food
        int count1;
        do {
            System.out.println("Enter the count of . :");
            count1 = input.nextInt();
        } while (count1 > k * k);
        int placed = 0;
        while (placed < count1) {
            int x = 1 + rnd.nextInt(k);
            int y = 1 + rnd.nextInt(k);
            if (array[x][y].equals(" ")) {
                array[x][y] = ".";
                placed++;
            }
        }
        //The pacman X
        int pacx = 1;
        int pacy = 1;
        array[pacx][pacy] = "X";
        // The move
        int[][] directions = {
                {-1, 0}, // w
                {1, 0},  // s
                {0, -1}, // a
                {0, 1}   // d
        };
        input.nextLine();
        long startTime = System.currentTimeMillis();
        label:
        while (count1 > 0) {
            for (int i = 0; i < k + 2; i++) {
                for (int j = 0; j < k + 2; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }
            String move = input.nextLine();
            int d = -1;
            switch (move) {
                case "w":
                    System.out.println("UP");
                    d = 0;
                    break;
                case "s":
                    System.out.println("LEFT");
                    d = 1;
                    break;
                case "a":
                    System.out.println("DOWN");
                    d = 2;
                    break;
                case "d":
                    System.out.println("RIGHT");
                    d = 3;
                    break;
                case "q":
                    System.out.println("EXIT");
                    break label;
                default:
                    System.out.println("WARNING");
                    break;
            }

            int newx = pacx + directions[d][0];
            int newy = pacy + directions[d][1];
            if (!array[newx][newy].equals("*")) {
                if (array[newx][newy].equals(".")) {
                    score++;
                    count1--;
                }
                array[pacx][pacy] = " ";
                pacx = newx;
                pacy = newy;
                array[pacx][pacy] = "X";
            }
        }
        //The time
        long endTime = System.currentTimeMillis();
        long timeElapsed = (endTime - startTime) / 1000;
        System.out.println("Score: " + score);
        System.out.println("Time: " + timeElapsed);
    }
}
