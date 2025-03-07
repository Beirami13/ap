package exercise1;
import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();
        for (int i=0; i<num; i++){
            for (int j=0; j<num; j++){
                System.out.print("*");
            }
            System.out.print(" ");
            if (i==0||i==num-1){
                for (int j=0; j<num; j++){
                    System.out.print("*");
                }
            }else {
                System.out.print("*");
                for (int j=0; j<num-2; j++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
