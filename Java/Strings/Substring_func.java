
import java.util.*;
class Substring_func {
    public static String Substring(String str, int si, int ei){
        String substr = "";
        for (int i=si; i<ei; i++){
            substr += str.charAt(i);
        }
        return substr;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = "Hello World";
        int si =0, ei =7;
        System.out.print(Substring(str, si, ei));
    }
}
