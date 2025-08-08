package BitManipulation;
import java.util.*;
public class Set_Count {
    public static int Set_Bit_Counter(int n){
        int count = 0;
        while (n > 0){
            if ((n & 1) != 0){
                count ++;
            }
            n = n >> 1;
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to count its SET BITS : ");
        int n = sc.nextInt();
        System.out.print("\nThe total count of Set Bits : " + Set_Bit_Counter(n));
    }
}