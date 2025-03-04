import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final double g= 9.8;
        System.out.println("Enter your weight:");
        Scanner input = new Scanner(System.in);
        float m = input.nextFloat();
        System.out.println("W is : "+(m*g));
    }
}