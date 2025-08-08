
import java.util.*;
class Clearing_last_iBits {
    public static int Clear_last_iBits(int n, int i){
        int BitMask = (~0) << i; //using ~0 == 11111 and shifting it till the parts to be cleared and the parts to be cleared will have 0000 beneath it
        return n & BitMask;// performing to clear the follow up values
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt() ;
        System.out.print("Enter the bits you want to clear : ");
        int i = sc.nextInt();
        System.out.print("The new value formed : "+Clear_last_iBits(n, i));

    }
}
