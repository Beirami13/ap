package exercise1;
import java.util.Scanner;

public class Print_line {
    public static void main(String[] args) {
        System.out.println("Enter strings: ");
        Scanner input = new Scanner(System.in);
        String st = input.nextLine();
        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            System.out.println(c);
            input.close();
        }
    }
}
