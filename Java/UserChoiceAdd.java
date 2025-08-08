package Java;
import java.util.*;
public class UserChoiceAdd{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int EvenSum = 0, OddSum = 0,choice;
        do{
            System.out.print("Enter a no. : ");
            int n = sc.nextInt();
            if (n % 2 == 0){
                EvenSum +=n;
            }else{
                OddSum +=n;
            }
            System.out.print("To continue press 1 , else press 0 .");
            choice = sc.nextInt();
        }while(choice == 1);
        System.out.println("Sum of Even integers : " + EvenSum);
        System.out.println("Sum of Odd integers : " + OddSum);
    }
}