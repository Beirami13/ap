package exercise1;

import java.util.Scanner;

public class Small_large {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner input = new Scanner(System.in);
        int max = input.nextInt();
        int min = max;
        while (input.hasNextInt()){
            int num = input.nextInt();
            if (num>max){
                max=num;
            } else if (num<min) {
                min=num;
            }
        }
        System.out.println("Smallest number: " + min);
        System.out.println("Largest number: " + max);
    }
}
