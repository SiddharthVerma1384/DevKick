package Java;
import java.util.*;
public class Factorial{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        if (n==0 && n==1){
            System.out.print("Factorial of "+n+ "is 1.");
        }else{
            int fact=1;
            for(int i = 1;i<=n;i++){
                fact*=i;
            }
            System.out.print("The foactorial of "+n+" is "+fact+".");
        }
    }
}