package ap.exercises.ex2;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_2_3 {
    private static final String SAVE_FILE = "pacmansave.txt";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        int score = 0;
        int pacx = 1, pacy = 1;
        int countf;
        String[][] array;
        // Load game
        System.out.println("Loading game? (yes/no):");
        String choice = input.nextLine();
        array = new String[0][0];
        // Loading game
        if (choice.equalsIgnoreCase("yes")) {
            int[] gameData = loadGame();
            if (gameData != null) {
                pacx = gameData[0];
                pacy = gameData[1];
                score = gameData[2];
                countf = gameData[3];
                System.out.println("Game loaded");
            } else {
                System.out.println("No game for load");
                return;
            }
        } else { // The structure
            System.out.println("Enter a number:");
            int k = input.nextInt();
            input.nextLine();
            array = new String[k + 2][k + 2];
            for (int i = 0; i < k + 2; i++) {
                for (int j = 0; j < k + 2; j++) {
                    array[i][j] = (i == 0 || i == k + 1 || j == 0 || j == k + 1) ? "*" : " ";
                }
            }
            // Food
            do {
                System.out.println("Enter the count of . :");
                countf = input.nextInt();
            } while (countf > k * k);
            for (int i = 0; i < countf; i++) {
                int x, y;
                do {
                    x = 1 + rnd.nextInt(k);
                    y = 1 + rnd.nextInt(k);
                } while (!array[x][y].equals(" "));
                array[x][y] = ".";
            }
            // Pacman X
            array[pacx][pacy] = "X";
        }
        // The movement
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        long startTime = System.currentTimeMillis();
        while (countf > 0) {
            for (String[] row : array) {
                System.out.println(String.join("", row));
            }
            String move = input.nextLine();
            if (move.equals("save")) {
                saveGame(array, pacx, pacy, score, countf);
                System.out.println("Game saved.");
                continue;
            } else if (move.equals("q")) {
                System.out.println("EXIT");
                break;
            }
        // Move
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
                default:
                    System.out.println("WARNING");
                    break;
            }
            if (d == -1) {
                System.out.println("WARNING");
                continue;
            }
            int newx = pacx + directions[d][0];
            int newy = pacy + directions[d][1];
            if (!array[newx][newy].equals("*")) {
                if (array[newx][newy].equals(".")) {
                    score++;
                    countf--;
                }
                array[pacx][pacy] = " ";
                pacx = newx;
                pacy = newy;
                array[pacx][pacy] = "X";
            }
        }
        long timeElapsed = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Score: " + score);
        System.out.println("Time: " + timeElapsed);
    }
    // Saving game
    private static void saveGame(String[][] board, int pacmanX, int pacmanY, int score, int food) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_FILE))) {
            for (String[] row : board) {
                writer.println(String.join("", row));
            }
            writer.printf("%d %d %d %d\n", pacmanX, pacmanY, score, food);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Loading the save game
    public static int[] loadGame() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            String line = reader.readLine();
            int k = line.split("")[0].length(); // fixing the size calculation
            String[][] board = new String[k + 2][k + 2];
            for (int i = 0; i < k + 2; i++) {
                line = reader.readLine();
                board[i] = line.split("");
            }
            String[] data = reader.readLine().split(" ");
            int pacx = Integer.parseInt(data[0]);
            int pacy = Integer.parseInt(data[1]);
            int score = Integer.parseInt(data[2]);
            int food = Integer.parseInt(data[3]);
            return new int[]{pacx, pacy, score, food};
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading game.");
            return null;
        }
    }
}
