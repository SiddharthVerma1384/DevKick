
import java.util.*;
class FirstLetter_Capital {
    public static String ToUpperCase(String str){
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length() -1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string as per the topic requirement : ");
        String str = sc.nextLine();
        System.out.println("\n*****Updated string*****");
        System.out.print(ToUpperCase(str));
    }
}
