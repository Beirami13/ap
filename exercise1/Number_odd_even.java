package exercise1;

import java.util.Scanner;

public class Number_odd_even {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner input = new Scanner(System.in);
        int odd=0;
        int even=0;
        while (input.hasNextInt()) {
            int num = input.nextInt();
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("The count of odd numbers is: " + odd);
        System.out.println("The count of even numbers is: " + even);
        input.close();
    }
}

