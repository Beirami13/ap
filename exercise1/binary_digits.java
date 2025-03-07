package exercise1;
import java.util.Scanner;

public class binary_digits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();
        while (num>0){
            System.out.println(num%2);
            num=num/2;
        }
    }
}
