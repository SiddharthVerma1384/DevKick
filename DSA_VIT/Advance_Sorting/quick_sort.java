package DSA_VIT.Advance_Sorting;
import java.util.*;
class quick_sort{
    int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low -1;

        for (int j=low; j<high; j++){
            if (arr[j] <= pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; 
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    void quicksort(int arr[], int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);

            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }
    void printArray(int arr[]){
        for (int i =0 ; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quick_sort qs = new quick_sort();
        System.out.println("Original array:");
        qs.printArray(arr);

        qs.quicksort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        qs.printArray(arr);
    }
}
