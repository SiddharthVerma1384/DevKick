package Java;
import java.util.*;
public class PrintMaxAndMinSumOfSubArray{
    public static void Max_n_Min(int arr[]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0;i<arr.length;i++){
            if (arr[i] > largest ){
                largest = arr[i];
            }
        }
        for (int i = 0;i<arr.length;i++){
            if (arr[i] < smallest ){
                smallest = arr[i];
            }
        }
        System.out.println("Largest = "+ largest);
        System.out.println("Smallest = "+ smallest);
    }
    public static void Print_Sub_Array(int arr[]){
        int index = 0;
        for (int i = 0;i<arr.length;i++){
            for (int j = i;j<= i;j++){
                for (int k = i ; k<=j ; k++){
                    System.out.print(arr[k] + " ");
                }                
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void Print_Max_n_Min_Sum(int arr[]){
        int size = (arr.length * (arr.length + 1)) / 2;
        int Sum_Array[] = new int[size];
        int index = 0;
        for (int i = 0;i<arr.length;i++){
            int sum = 0;
            for (int j = i;j<arr.length;j++){
                sum += arr[j];
                Sum_Array[index++] = sum;
            }
        }
        Max_n_Min(Sum_Array);
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numbers[] = {2, 4, 6, 8, 10};
        Print_Sub_Array(numbers);
        Print_Max_n_Min_Sum(numbers);

    }
}