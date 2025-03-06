package exercise1;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers: ");
        int n = input.nextInt();
        double[] numbers = new double[n];
        System.out.println("Enter floating-point: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextDouble();
        }
        input.close();
        System.out.println("\nResults:");
        System.out.println("Average: " + Average(numbers));
        System.out.println("Smallest: " + Smallest(numbers));
        System.out.println("Largest: " + Largest(numbers));
        System.out.println("Range: " + getRange(numbers));
    }

    public static double Average(double[] numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }

    public static double Smallest(double[] numbers) {
        double smallest = numbers[0];
        for (double num : numbers) {
            if (num < smallest) {
                smallest = num;
            }
        }
        return smallest;
    }

    public static double Largest(double[] numbers) {
        double largest = numbers[0];
        for (double num : numbers) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    public static double getRange(double[] numbers) {
        return Largest(numbers) - Smallest(numbers);
    }
}

