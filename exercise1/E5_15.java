package exercise1;
import java.util.Scanner;

public class E5_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double income = scanner.nextDouble();
        double tax = 0;
        if (income > 500000) {
            tax += (income - 500000) * 0.06;
            income = 500000;
        }
        if (income > 250000) {
            tax += (income - 250000) * 0.05;
            income = 250000;
        }
        if (income > 100000) {
            tax += (income - 100000) * 0.04;
            income = 100000;
        }
        if (income > 75000) {
            tax += (income - 75000) * 0.03;
            income = 75000;
        }
        if (income > 50000) {
            tax += (income - 50000) * 0.02;
            income = 50000;
        }
        if (income > 0) {
            tax += income * 0.01;
        }
        System.out.println(tax);
    }
}
