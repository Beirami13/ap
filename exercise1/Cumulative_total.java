package exercise1;

import java.util.Scanner;

public class Cumulative_total {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        int sum=0;
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int num = input.nextInt();
            sum += num;
            System.out.print(sum + " ");
        }
        input.close();
    }
}