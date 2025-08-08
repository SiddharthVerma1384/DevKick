package Array_2D;
import java.util.*;
public class StairCase_Searching{
    public static boolean Staircase_Search(int arr[][] , int key){
        int row = arr.length -1, coloumn = 0;
        while(row>=0 && coloumn<arr[0].length){
            if (arr[row][coloumn] == key){
                System.out.print("The key element "+key+" is found at "+"("+(row + 1)+","+(coloumn+1)+")");
                return true;
            }
            else if(arr[row][coloumn] > key){
                row --;
            }else{
                coloumn ++;
            }
        }
        System.out.println("No such element is present in the given array!!!");
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int matrix[][] = {{10,20,30,40}, {15,25,35,45}, {27,29,37,48}, {32,33,39,50}};
        System.out.print("Enter a number to find in the array : ");
        int key = sc.nextInt();
        Staircase_Search(matrix, key);
    }
}