
/*
 * NAME :- SIDDHARTH VERMA
 * REG N0.:- 24BCB0118
 */

 import java.util.*;
 class Linear_Search {
    public static int LinearSearch(int arr[] , int val){
        for(int i=0; i<arr.length; i++){
            if (arr[i] == val){
                return i;
            }
        }
        return -1;
    }
     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nums[] = {14,12,3,5,9,7,5,4,12,13,22};
        System.out.println("NAME : SIDDHARTH VERMA\nREG NO:- 24BCB0118\n");
        System.out.println("*********************");
        System.out.print("Enter the value for best case search : " );
        int val_1 = sc.nextInt();
        System.out.println("The index of "+val_1+" is : "+LinearSearch(nums,val_1));
        System.out.print("Enter the value for average case search : " );
        int val_2 = sc.nextInt();
        System.out.println("The index of "+val_2+" is : "+LinearSearch(nums,val_2));
        System.out.print("Enter the value for worst case search : " );
        int val_3 = sc.nextInt();
        System.out.println(LinearSearch(nums,val_3) != -1 ? ("The index of "+val_3+" is : " + LinearSearch(nums, val_3)) : "Element NOT FOUND !!!" ); 
        System.out.println("*********************");      
     }
 }
