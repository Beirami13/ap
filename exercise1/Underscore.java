package exercise1;
import java.util.Scanner;

public class Underscore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String st = input.nextLine();
        StringBuilder modifiedString = new StringBuilder(st);
        for (int i = 0; i < st.length(); i += 2) {
            char c = st.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                modifiedString.setCharAt(i, '-');
            }
        }
        System.out.println( modifiedString.toString());
        input.close();
    }
}
