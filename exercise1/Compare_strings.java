package exercise1;
import java.util.Scanner;

public class Compare_strings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter strings: ");
        String a = input.next();
        String b = input.next();
        String c = input.next();
        if (a.compareTo(b) > 0) {
            String temp = a;
            a = b;
            b = temp;
        }
        if (b.compareTo(c) > 0) {
            String temp = b;
            b = c;
            c = temp;
        }
        if (a.compareTo(b) > 0) {
            String temp = a;
            a = b;
            b = temp;
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        input.close();
    }
}
