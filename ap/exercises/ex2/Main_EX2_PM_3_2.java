package ap.exercises.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main_EX2_PM_3_2 extends JFrame implements KeyListener {
    final int boxSize = 30;
    int gridSize;
    String[][] array;
    int pacx = 1, pacy = 1;
    final int LEFT = 0, RIGHT = 1, UP = 2, DOWN = 3;
    int direction = RIGHT;

    public Main_EX2_PM_3_2(int k) {
        gridSize = k + 2;
        array = new String[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (i == 0 || i == gridSize - 1 || j == 0 || j == gridSize - 1)
                array[i][j] = "*";
        else
                array[i][j] = " ";
            }
        }
        array[pacx][pacy] = "X";

        setSize(gridSize * boxSize, gridSize * boxSize);
        setTitle("Pac-Man");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        drawGrid(g2d);
    }

    void drawGrid(Graphics2D g2d) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (array[i][j].equals("*"))
                    g2d.setColor(Color.BLACK);
                else if (i == pacx && j == pacy)
                    g2d.setColor(Color.BLUE);
                else
                    g2d.setColor(Color.WHITE);
                g2d.fillRect(j * boxSize, i * boxSize, boxSize, boxSize);
                g2d.setColor(Color.GRAY);
                g2d.drawRect(j * boxSize, i * boxSize, boxSize, boxSize);
            }
        }
    }

    void movePacman() {
        int[][] directions = {
                {0, -1},  // LEFT
                {0, 1},   // RIGHT
                {-1, 0},  // UP
                {1, 0}    // DOWN
        };

        int newx = pacx + directions[direction][0];
        int newy = pacy + directions[direction][1];

        if (array[newx][newy].equals(" ")) {
            array[pacx][pacy] = " ";
            pacx = newx;
            pacy = newy;
            array[pacx][pacy] = "X";
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) direction = LEFT;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) direction = RIGHT;
        else if (e.getKeyCode() == KeyEvent.VK_UP) direction = UP;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) direction = DOWN;

        movePacman();
        repaint();
    }

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter a number:");
        int k = Integer.parseInt(input);
        new Main_EX2_PM_3_2(k);
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}