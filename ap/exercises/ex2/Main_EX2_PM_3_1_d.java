package ap.exercises.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Main_EX2_PM_3_1_d extends JFrame implements KeyListener {
    Point pacmanPoint = new Point();
    final int width = 300, height = 300, boxSize = 5;
    static int direction = 1;
    final int LEFT = 1, RIGHT = 2, TOP = 3, BOTTOM = 4;
    Point dotPoint = new Point();

    int score = 0;
    final int maxScore = 10;
    final long maxDuration = 60 * 1000; // 60 seconds
    long startTime;

    public Main_EX2_PM_3_1_d() {
        addKeyListener(this);
        pacmanPoint.setLocation((width / boxSize) / 2, (height / boxSize) / 2);
        getNewDotPointLocation();
        setSize(width, height);
        setTitle("Pacman Game");
        startTime = System.currentTimeMillis();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g.clearRect(0, 0, width, height);

        if (checkGameEnd()) return;

        logic();
        drawPacman(g2D);
        drawDotPoint(g2D);
        drawScore(g2D);
        setVisible(true);
    }

    private void drawPacman(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect(pacmanPoint.x * boxSize, pacmanPoint.y * boxSize, boxSize, boxSize);
    }

    private void drawDotPoint(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillRect(dotPoint.x * boxSize, dotPoint.y * boxSize, boxSize, boxSize);
    }

    private void drawScore(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        String s = "Score: " + score;
        g2d.drawString(s, 25, 50);
    }

    private void logic() {
        if (dotPoint.x == pacmanPoint.x && dotPoint.y == pacmanPoint.y) {
            getNewDotPointLocation();
            score++;
            System.out.println("Score: " + score);
        }
        movePacman();
    }

    private void movePacman() {
        int xMovement = 0;
        int yMovement = 0;

        switch (direction) {
            case LEFT:
                xMovement = -1;
                break;
            case RIGHT:
                xMovement = 1;
                break;
            case TOP:
                yMovement = -1;
                break;
            case BOTTOM:
                yMovement = 1;
                break;
        }

        pacmanPoint.setLocation(pacmanPoint.x + xMovement, pacmanPoint.y + yMovement);
        handleCrossBorder();
    }

    private void getNewDotPointLocation() {
        Random rand = new Random();
        int delta = boxSize * 2;
        dotPoint.setLocation(rand.nextInt(width / boxSize - 2 * delta) + delta,
                rand.nextInt(height / boxSize - 2 * delta) + delta);
    }

    private boolean checkGameEnd() {
        long currentTime = System.currentTimeMillis();

        if ((currentTime - startTime) >= maxDuration) {
            JOptionPane.showMessageDialog(this, "Time is up", "Game Over", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return true;
        }

        if (score >= maxScore) {
            JOptionPane.showMessageDialog(this, "Maximum Score", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            return true;
        }

        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (checkGameEnd()) return;

        if (e.getKeyCode() == KeyEvent.VK_UP)
            direction = TOP;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            direction = BOTTOM;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            direction = LEFT;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            direction = RIGHT;
        else if (e.getKeyCode() == KeyEvent.VK_P)
            direction = 0;
        else
            direction = -1;

        System.out.println("Direction: " + direction + "  <- Key Code: " + e.getKeyCode());

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    private void handleCrossBorder() {
        if (pacmanPoint.x < 0) pacmanPoint.x = width / boxSize - 1;
        if (pacmanPoint.x >= width / boxSize) pacmanPoint.x = 0;
        if (pacmanPoint.y < 0) pacmanPoint.y = height / boxSize - 1;
        if (pacmanPoint.y >= height / boxSize) pacmanPoint.y = 0;
    }

    public static void main(String[] args) {
        Main_EX2_PM_3_1_d frame = new Main_EX2_PM_3_1_d();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
