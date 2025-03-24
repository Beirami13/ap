package exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_1_4 {
    public static void main(String[] args) {
        System.out.println("Enter :");
        Scanner input = new Scanner(System.in);
        String move = input.nextLine();

        switch (move) {
            case "w":
                System.out.println("UP");
                break;
            case "a":
                System.out.println("LEFT");
                break;
            case "s":
                System.out.println("DOWN");
                break;
            case "d":
                System.out.println("RIGHT");
                break;
            case "q":
                System.out.println("EXIT");
                break;
            default:
                System.out.println("WARNING");
        }
    }
}
