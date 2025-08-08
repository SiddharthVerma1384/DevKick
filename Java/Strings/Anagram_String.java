
import java.util.*;
class Anagram_String{
    public static void Is_Anagram(String str1, String str2){
        boolean result;
        if (str1.length() == str2.length()){
            char str1_Array[] = str1.toCharArray();
            char str2_Array[] = str2.toCharArray();
            Arrays.sort(str1_Array);
            Arrays.sort(str2_Array);
            result = Arrays.equals(str1_Array, str2_Array);
            if (result){
                System.out.print("Anagrams!!!");
            }else{
                System.out.print("Okkk No Anagramsss !!!");
            }
        }else{
            System.out.print("Eeee chotuuu !!!");
        }        
        // return result;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        String str1 = "race";
        String str2 = "care";
        String str3 = "fare";
        String str4 = "my";
        System.out.println("************");
        Is_Anagram(str1, str2);
        System.out.println("\n************");
        Is_Anagram(str1, str3);

        System.out.println("\n************");
        Is_Anagram(str1, str4);
    }
}
