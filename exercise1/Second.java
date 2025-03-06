package exercise1;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String text = input.nextLine();
        for (int i = 1; i < text.length(); i += 2) {
            System.out.print(text.charAt(i));
        }
        input.close();
    }
}
