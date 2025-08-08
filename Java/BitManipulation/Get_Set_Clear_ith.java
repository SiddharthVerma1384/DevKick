package BitManipulation;
import java.util.*;
public class Get_Set_Clear_ith {
    
    public static int Get_ith(int n, int i){
        int BitMask = 1<<i;
        if ((n & BitMask) == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public static int Set_ith(int n, int i){
        int BitMask = 1<<i;
        return n | BitMask;
    }

    public static int Clear_ith(int n, int i){
        int BitMask = ~(1<<i);
        return n & BitMask;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Get_ith(10, 2));
        System.out.println(Set_ith(10, 2));
        System.out.println(Clear_ith(10, 1));
    }
}