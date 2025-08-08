package BitManipulation;
import java.util.*;
public class ModularExponentiation {
    public static long Modular_Exponentiation(long a, long n, long mod){
        a = a % mod;
        long ans = 1;
        while (n > 0){
            if ((n & 1) != 0){
                ans = (ans * a) % mod;
            }
            a = (a * a) % mod;
            n = n >> 1;
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find its Modular Exponentiation : ");        
        int a = sc.nextInt(); 
        System.out.print("Enter its exponent : ");
        int n = sc.nextInt();
        System.out.print("Enter its modulo : ");
        int mod = sc.nextInt();
        System.out.print("\nThe Output is : " + Modular_Exponentiation(a, n,mod));
        
    }
}