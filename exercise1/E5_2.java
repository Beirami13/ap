package exercise1;
import java.util.Scanner;

public class E5_2 {
    public static void main(String[] args){
        System.out.println("Enter a number: ");
        Scanner input = new Scanner(System.in);
        float num = input.nextFloat();

        if (num==0){
            System.out.println("Zero");
        }else if (num<0){
            System.out.println("negative");
        }else{
            System.out.println("positive");
        }

        num = Math.abs(num);
        if (num<1){
            System.out.println("small");
        }else if (num>1000000){
            System.out.println("large");
        }
    }
}
