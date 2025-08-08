package Java;
import java.util.*;
public class Linear_Largest_Smallest_ele_Arr{
    public static int Get_Largest(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        return largest;
        
    }
    public static int Get_Smallest(int arr[]){
        int smallest = Integer.MAX_VALUE;
        for(int i =0;i<arr.length;i++){
            if(arr[i]<smallest){
                smallest = arr[i];
            }
        }
        return smallest;
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int Numbers[] = {1,2,6,-4,3,5};
        int largest_num = Get_Largest(Numbers);
        int smallest_num = Get_Smallest(Numbers);
        System.out.println("The largest number in the array is : "+largest_num);
        System.out.println("The smallest number in the array is : "+smallest_num);
        
    }
}