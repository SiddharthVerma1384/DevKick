package Java;
import java.util.*;
public class Prime_nos{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        if (n==2){
            System.out.println("The number " + n +" is a prime number .");
        }else{
            boolean isPrime = true;
            for(int i = 2;i<=Math.sqrt(n);i++){
                if (n%i == 0){
                    isPrime = false;
                }
            }
            if (isPrime){
                System.out.print("The number "+n+" is a prime number.");
            }else{
                System.out.print("The number "+n+" is not a prime number.");
            }
        }
    }
}