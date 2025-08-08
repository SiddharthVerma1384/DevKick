package Java;
import java.util.*;
public class Reverse_array{
    public static void Reversed_array(int arr[]){
        int start = 0,end = arr.length - 1;
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;end-- ;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int numbers[] = {2, 4, 6,16, 17,7,8};
        Reversed_array(numbers);
        System.out.println("Reversed Array :-");
        for (int i = 0;i<numbers.length;i++){
            System.out.print(numbers[i] + " ");
        }
    }
}