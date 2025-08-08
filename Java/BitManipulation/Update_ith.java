package BitManipulation;
import java.util.*;
public class Update_ith {
    public static int Update_ith(int n, int i,int val){
        n = n & (~(1<<i));  //clear the ith bit on which operation is going to happen
        int BitMask = val << i; //brings the bit to be inserted to the cleared space
        return n | BitMask; //0 | val == val
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.print("Enter the position you want to update : ");
        int i = sc.nextInt();
        System.out.print("Enter the value of bit you want to insert : ");
        int val = sc.nextInt();
        System.out.print("\nThe new value after inserting the new Bit :-\nNew Value : "+Update_ith(n, i, val));
    }
}