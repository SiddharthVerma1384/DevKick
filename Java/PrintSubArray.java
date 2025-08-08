
import java.util.*;
class PrintSubArray{
    public static void Print_Sub_array(int arr[]){
        int total_pair = 0;
        for (int i = 0;i<arr.length;i++){
            for (int j = i;j<arr.length;j++){
                for (int k = i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
                total_pair ++;
            }
            System.out.println();
        }
        System.out.print("Total possiblity of forming of Sub Array : " + total_pair);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int numbers[] = {2,4,6,8,10};
        Print_Sub_array(numbers);

    }
}
