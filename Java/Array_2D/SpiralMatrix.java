package Array_2D;
import java.util.*;
public class SpiralMatrix{
    public static void Spiral_Matrix(int arr[][]){
        int startRow = 0, startCol = 0, endRow = arr.length-1, endCol = arr[0].length-1;

        while (startRow <= endRow && startCol <= endCol){
            //top boundary
        for (int j =startCol; j<= endCol; j++){
            System.out.print(arr[startRow][j] + " ");
        }

        //right boundary
        for (int i=startRow + 1; i<= endRow; i++){
            
            System.out.print(arr[i][endCol] + " ");
        }

        //bottom boundary
        for (int j=endCol - 1; j>= startCol; j--){
            if (startRow == endRow){
                break;
            }
            System.out.print(arr[endRow][j] + " ");
        }

        //left boundary
        for (int i=endRow - 1; i>= startRow + 1; i--){
            if (startCol == endCol){
                break;
            }
            System.out.print(arr[i][startCol] + " ");
        }
        startRow++;
        startCol++;
        endRow--;
        endCol--;
        }
        
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int matrix[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        Spiral_Matrix(matrix);

    }
}
