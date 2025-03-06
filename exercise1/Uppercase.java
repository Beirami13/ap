package exercise1;
import java.util.Scanner;

public class Uppercase {
    public static void main(String[] args) {
        System.out.println("Enter strings: ");
        Scanner input = new Scanner(System.in);
        String st = input.nextLine();
        for (int i = 0; i < st.length() - 1; i++) {
            char c = st.charAt(i);
            if (Character.isUpperCase(c)){
                System.out.println(c);
            }
        }
        input.close();
    }
}
