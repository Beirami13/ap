package ap.exercises.ex2;

import java.io.FileWriter;
import java.io.IOException;

public class Main_EX2_PM_2_4 {
    private char[][] matrix;
    private int k;
    private int c;
    private int pacmanX;
    private int pacmanY;
    private int score;
    private long startTime;

    public Main_EX2_PM_2_4(int k, int c) {
        this.k = k;
        this.c = c;
        matrix = new char[k][c];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = '.';
            }
        }

        pacmanX = 0;
        pacmanY = 0;
        matrix[pacmanX][pacmanY] = 'P';

        score = 0;
        startTime = System.currentTimeMillis();
    }

    public void printMatrix() {
        System.out.println("Matrix:");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printScore() {
        System.out.println("Score: " + score);
    }

    public void printRemainTime() {
        long elapsed = (System.currentTimeMillis() - startTime) / 1000;
        long remain = Math.max(0, 60 - elapsed);
        System.out.println("Remain Time: " + remain + " seconds");
    }

    public void move(int direction) {
        int newX = pacmanX;
        int newY = pacmanY;

        if (direction == 0 && pacmanX > 0) newX--; // up
        else if (direction == 1 && pacmanX < k - 1) newX++; // down
        else if (direction == 2 && pacmanY > 0) newY--; // left
        else if (direction == 3 && pacmanY < c - 1) newY++; // right

        if (matrix[newX][newY] == '.') {
            score++;
        }

        matrix[pacmanX][pacmanY] = ' ';
        pacmanX = newX;
        pacmanY = newY;
        matrix[pacmanX][pacmanY] = 'P';
    }

    public void save() {
        try {
            FileWriter writer = new FileWriter("game_save.txt");
            writer.write("Score: " + score + "\n");
            writer.write("Pacman Position: (" + pacmanX + ", " + pacmanY + ")\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}