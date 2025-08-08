package Strings;
import java.util.*;
public class String_Compression {
    public static String Str_Comp(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while( i<str.length() -1 && str.charAt(i) == str.charAt(i+1) ) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));

            if(count > 1){
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = "aaabbccccddd";
        System.out.println(Str_Comp(str));
    }
}