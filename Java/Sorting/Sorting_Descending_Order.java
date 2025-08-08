package Sorting;
import java.util.*;
public class Sorting_Descending_Order{
    public static void Bubble_Sort(int arr[]){
        int n = arr.length;
        for (int i=0 ; i<n-1 ; i++){
            for (int j=0 ; j<n-1-i ; j++){
                if (arr[j+1] > arr[j]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void Selection_Sort(int arr[]){
        int n = arr.length;
        for(int i=0 ; i<n-1 ; i++){
            int minPos = i;
            for (int j=i+1 ; j<n ; j++){
                if(arr[minPos] < arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[minPos] ;
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void Insertion_Sort(int arr[]) {
        int n = arr.length;
        for(int i=1 ; i<n ; i++){
            int curr = arr[i];
            int  prev = i-1;
            while (prev >= 0 && arr[prev] < curr){
                arr[prev + 1] = arr[prev];
                prev --;
            }
            arr[prev+1] = curr;
        }
    }

    public static void Counting_Sort(int arr[]) {
        int n = arr.length;
        int largest = Integer.MIN_VALUE;
        for (int i=0 ; i<n ;i++){
            if (arr[i] > largest){
                largest = arr[i];
            }
        }
        int count[] = new int [largest+1];
        for(int i=0 ; i<n ; i++){
            count[arr[i]]++;
        }
        int j = 0;
        for (int i=count.length - 1 ; i>=0 ; i--){
            while (count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void Print_Array(int arr[]){
        int n = arr.length;
        for (int i=0 ; i<n ; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int nums[] = {3,6,2,1,8,7,4,5,3,1};
        // System.out.println("\n******* Sorting through Bubble Sort *******");
        // Bubble_Sort(nums);
        // System.out.println("\nSorted Array :-");
        // Print_Array(nums);
        System.out.println("\n******* Sorting through Selection Sort *******");
        Selection_Sort(nums);
        System.out.println("\nSorted Array :-");
        Print_Array(nums);
        // System.out.println("\n******* Sorting through Insertion Sort *******");
        // Insertion_Sort(nums);
        // System.out.println("\nSorted Array :-");
        // Print_Array(nums);
        // System.out.println("\n******* Sorting through Counting Sort *******");
        // Counting_Sort(nums);
        // System.out.println("\nSorted Array :-");
        // Print_Array(nums);

    }
} 