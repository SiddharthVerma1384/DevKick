package Java;
import java.util.*;
public class UserFavMultiplication{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        System.out.println("Multiplication of "+n+" is :-->>");
        for (int i = 1;i<=10;i++){
            System.out.println(n +" x "+ i +" = "+(n*i));
        }
    }
}