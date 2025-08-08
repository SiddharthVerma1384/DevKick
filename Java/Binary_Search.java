
/*
 * NAME :- SIDDHARTH VERMA
 * REG N0.:- 24BCB0118
 */

import java.util.*;
class Binary_Search{
    public static int Bin_Search(int arr[] ,int key){
        Arrays.sort(arr);  // Sort the array as binary search is only applicable for Sorted array
        int start = 0 , end = arr.length - 1;
        while(start<=end){
            int mid = (start + end)/2 ;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] < key){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        int numbers[] = {14,12,3,5,9,7,5,4,12,13,22}; //Sorted Array : {3,4,5,5,7,9,12,12,13,14,22}
        System.out.println("NAME : SIDDHARTH VERMA\nREG NO:- 24BCB0118\n");
        System.out.println("************BINARY SEARCH**************\n");
        System.out.print("Enter a number you want to find for BEST CASE: ");
        int key_best = sc.nextInt();
        System.out.println("The index value for "+key_best+" is : "+Bin_Search(numbers, key_best));
        System.out.print("Enter a number you want to find for AVERAGE CASE: ");
        int key_avg = sc.nextInt();
        System.out.println("The index value for "+key_avg+" is : "+Bin_Search(numbers, key_avg));
        System.out.print("Enter a number you want to find for WORST CASE: ");
        int key_worst = sc.nextInt();
        System.out.println(Bin_Search(numbers, key_worst) == -1 ? "ELEMENT NOT FOUND !!!" : "The index value for "+key_worst+" is : "+Bin_Search(numbers, key_worst));
        System.out.println("\n*****************************************");
    }
}
