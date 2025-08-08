
import java.util.*;
class is_Palindrome{
    public static boolean is_Palindrome(int num){
        int rev = 0;
        int palindrome = num;
        while(num>0){
            int last_digit = num % 10;
            rev = (rev * 10)+last_digit;
            num/=10;
        }
        if (rev == palindrome){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter a number to check if palindrome : ");
        int num = sc.nextInt();
        if (is_Palindrome(num)){
            System.out.print("Number "+num+" is Palindrome.");
        }else{
            System.out.print("Number is not a palindrome.");
        }
    }
}
