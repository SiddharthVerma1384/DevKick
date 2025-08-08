package Strings;
import java.util.*;
public class Palindrome_String{
    public static boolean Is_Palindrome(String str){
        for (int i=0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter a string to check whether its a palindrome or not : ");
        String str = sc.nextLine();
        if(Is_Palindrome(str)){
            System.out.println("Palindrome!!!");
        }else{
            System.out.println("Not Palindromme!!!");
        }
    }
}