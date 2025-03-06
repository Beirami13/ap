package exercise1;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        Scanner input = new Scanner(System.in);
        String st = input.nextLine();
        input.close();
        for (int i = st.length() - 1; i >= 0; i--) {
            System.out.print(st.charAt(i));
        }
        System.out.println();
    }
}
