package Strings;
import java.util.*;
public class Vowel_counter {
    public static int VowelCount(String str){
        int count = 0;
        str = str.toLowerCase();
        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if (ch == 'a'||ch == 'e'||ch == 'i'||ch == 'o'||ch == 'u'){
                count+=1;
            }
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string you are thinking about : ");
        String str = sc.nextLine();
        System.out.print("The vowel count in your string is : " + VowelCount(str));
    }
}