package exercise1;

public class even2_100 {
    public static void main(String[] args) {
        int sum=0;
        for (int i=2;i<=100;i+=2){
            sum+=i;
        }
        System.out.println("The sum from 2 to 100 is "+sum);
    }
}
