package DSA_VIT.Searching;
import java.util.*;
public class BinSearch_iterative_n_rec{
    public static int Bin_Search(int arr[], int key){
        int start = 0, end = arr.length - 1;
        while (start <= end){
            int mid = (start + end)/2;
            if (arr[mid] == key){
                return mid;
            }else if (arr[mid] < key){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int Rec_Bin_Search(int arr[], int start, int end, int key){
        while (start <= end){
            int mid = (start + end)/2;

            if(arr[mid] == key){
                return mid;
            }else if (arr[mid] < key){
                Rec_Bin_Search(arr, mid + 1, end, key);
            }else{
                Rec_Bin_Search(arr, start, mid - 1, key);
            }
        }

        return -1;
    }

    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        int arr[] = {2,4,55,67,88,212};
        System.out.println();
        System.out.print("Index value through iterative call : " + Bin_Search(arr, 4));
        System.out.println();
        System.out.print("Index value through recursive call : " + Rec_Bin_Search(arr, 0, arr.length - 1, 55));
    }
}