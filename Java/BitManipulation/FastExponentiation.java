package BitManipulation;
import java.util.*;
public class FastExponentiation {
    public static int Fast_Exponentiation(int a, int n){
        int ans = 1;
        while (n > 0){
            if ((n & 1) != 0){
                ans = ans * a; 
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find its Fast Exponentiation : ");        
        int a = sc.nextInt(); 
        System.out.print("Enter its exponent : ");
        int n = sc.nextInt();
        System.out.print("\nThe Output is : " + Fast_Exponentiation(a, n));
    }
}