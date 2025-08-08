
import java.util.*;
class Swap_Using_BitMan{
    public static void Swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.print("\nValues after Swapping :-");
        System.out.print("\na = "+a+"\nb = "+b);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of a : ");
        int a = sc.nextInt();
        System.out.print("Enter the value of b : ");
        int b = sc.nextInt();
        System.out.print("Values before Swapping :-");
        System.out.print("\na = "+a+"\nb = "+b);
        Swap(a, b);        
    }
}
