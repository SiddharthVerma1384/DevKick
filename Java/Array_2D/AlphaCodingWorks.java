
import java.util.*;
class AlphaCodingWorks{
    public static int Count_Key_Elmnt(int arr[][] , int key){
        int n = arr.length, m = arr[0].length;
        int count = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (arr[i][j] == key) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int Sum_Of_Row(int arr[][], int row){
        int m = arr[0].length;
        int sum =0;
        for(int i=0; i<m; i++){
            sum+= arr[row-1][i];
        }
        return sum;
    }

    public static void Print_Arr(int arr[][]){
        int n = arr.length, m = arr[0].length;
        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void Transpose_Matrix(int arr[][]){
        int n = arr.length, m = arr[0].length;
        int transpose[][] = new int [m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                transpose[j][i] = arr[i][j];
            }
        }
        Print_Arr(transpose);
    }
    
    
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int array[][] = {{4,7,8} , {8,8,7}};
        int nums[][] = {{1,4,9} ,{11,4,3}, {2,2,3}};
        int matrix[][] = {{1,2,3} ,{4,5,6}};
        // System.out.print("Enter the key element to find : ");
        // int key = sc.nextInt();
        // System.out.print("Enter the row number to find its sum : ");
        // int row = sc.nextInt();        
        // System.out.print("Output : "+Count_Key_Elmnt(array, key));
        // System.out.print("Sum of the input row : "+Sum_Of_Row(nums, row));
        System.out.print("*****Transpose Matrix*****\n");
        Transpose_Matrix(nums);
        // Print_Arr(matrix);
    }
}
