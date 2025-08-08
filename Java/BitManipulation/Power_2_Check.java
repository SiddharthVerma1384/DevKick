package BitManipulation;
import java.util.*;
public class Power_2_Check {
    public static boolean Is_PowerOf_2(int n){
        int BitMark = n & (n-1);
        if (BitMark == 0) {
            return true;
        }else{
            return false;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check whether it is power of 2 or not : ");
        int n = sc.nextInt();
        if(Is_PowerOf_2(n)){
            System.out.println("Yes !! The number, "+n+" is a power of 2.....");
        }else{
            System.out.println("No !! The number, "+n+" is not a power of 2.....");
        }
    }
}