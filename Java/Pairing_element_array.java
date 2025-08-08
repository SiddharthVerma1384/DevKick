package Java;
import java.util.*;
public class Pairing_element_array{
    public static void Pairing_ele_print(int arr[]){
        int total_pairs = 0;
        for (int i = 0;i<arr.length;i++){
            for (int j = i+1;j<arr.length;j++){
                System.out.print("(" + arr[i]+ "," + arr[j] + ")" + " ");
                total_pairs+=1;
            }
            System.out.println();
        }
        System.out.print("Total pairs possible : "+ total_pairs); // n(n-1) / 2
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int numbers[] = {2,4,6,8,10};
        Pairing_ele_print(numbers);

    }
}