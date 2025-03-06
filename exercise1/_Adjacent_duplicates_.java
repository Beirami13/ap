package exercise1;
import java.util.Scanner;

public class _Adjacent_duplicates_ {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        String line = input.nextLine();
        String[] numbers = line.split(" ");
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i].equals(numbers[i + 1])) {
                System.out.print(numbers[i] + " ");
                while (i < numbers.length - 1 && numbers[i].equals(numbers[i + 1])) {
                    i++;
                }
            }
        }
        input.close();
    }
}
