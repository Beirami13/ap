package exercise1;
import java.util.Scanner;

public class Sum_odd_statics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();
        int sum=0;
        while (num>0){
            if((num%10)%2==1){
                sum+=(num%10);
            }
            num=num/10;
        }
        System.out.println("The sum is "+sum);
    }
}
