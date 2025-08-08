
import java.util.*;
class Odd_Or_Even {
    public static void OddEven_check_Bit_perform(int num){
        int Bitmask = 1;
        if ((num & Bitmask) == 1){
            System.out.println("Odd Number !!");;
        }else{
            System.out.println("Even Number !!");
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        OddEven_check_Bit_perform(13);
        OddEven_check_Bit_perform(3);
        OddEven_check_Bit_perform(2);
        OddEven_check_Bit_perform(18);
    }
}
