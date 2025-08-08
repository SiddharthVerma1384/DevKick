package Array_2D;
import java.util.*;
public class Largest_n_Smallest_Elmnt{
    public static void Large_n_Small(int arr[][]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int n = arr.length, m = arr[0].length;
        int x =0, y=0, z=0, a=0;
        for (int i=0; i<n; i++){
            for (int j=0 ; j<m ; j++){
                if (arr[i][j] > largest){
                    largest = arr[i][j];
                    x =i;
                    y =j;
                }
            }
        }
        System.out.println("Largest element is "+largest+" : found at "+"("+x+","+y+")");
        for (int i=0; i<n; i++){
            for (int j=0 ; j<m ; j++){
                if (arr[i][j] < smallest){
                    smallest = arr[i][j];
                    z = i;
                    a = j;
                }
            }
        }
        System.out.println("Smallest element is "+smallest+" : found at "+"("+z+","+a+")");
    }

    public static void Print_2D_Array(int arr[][]){
        int n = arr.length, m = arr[0].length;
        for (int i=0 ; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int rows = sc.nextInt();
        System.out.print("Enter number of coloumns : ");
        int coloumn = sc.nextInt();
        int matrix[][] = new int [rows][coloumn];
        int n= matrix.length,m = matrix[0].length;
        System.out.println("Enter the elemrnts of the array :---");
        for (int i=0 ; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("\nYour Matrix is : \n");
        Print_2D_Array(matrix);
        System.out.println("\nThe largest and Smallest element is :---\n");
        Large_n_Small(matrix);
    }
}
