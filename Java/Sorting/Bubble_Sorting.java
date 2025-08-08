
import java.util.*;
class Bubble_Sorting{
    public static void Bubble_Sort(int arr[]) {
        for(int i=0 ; i<arr.length - 1; i++){
            for (int j=0 ; j<arr.length - 1 -i ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void Print_Array(int arr[]){
        for(int i = 0;i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[] = {5, 4, 1, 3, 2};
        Bubble_Sort(arr);
        Print_Array(arr);
    }
}
