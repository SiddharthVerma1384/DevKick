
import java.util.*;

class Recursive_Binary_Search {
    public static int Recursive_Bin_Search(int arr[], int start, int end, int key) {
        Arrays.sort(arr);
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (key > arr[mid]) {
            return Recursive_Bin_Search(arr, mid + 1, end, key);
        } else {
            return Recursive_Bin_Search(arr, start, mid - 1, key);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nums[] = { 14, 12, 3, 5, 9, 7, 5, 4, 12, 13, 22 };
        System.out.println("NAME : SIDDHARTH VERMA\nREG NO:- 24BCB0118\n");
        System.out.println("************RECURSIVE BINARY SEARCH**************\n");
        System.out.print("Enter a number you want to find for BEST CASE: ");
        int key_best = sc.nextInt();
        System.out.println("The index value for " + key_best + " is : "
                + Recursive_Bin_Search(nums, 0, nums.length - 1, key_best));
        System.out.print("Enter a number you want to find for AVERAGE CASE: ");
        int key_avg = sc.nextInt();
        System.out.println(
                "The index value for " + key_avg + " is : " + Recursive_Bin_Search(nums, 0, nums.length - 1, key_avg));
        System.out.print("Enter a number you want to find for WORST CASE: ");
        int key_worst = sc.nextInt();
        System.out.println(Recursive_Bin_Search(nums, 0, nums.length - 1, key_worst) == -1 ? "ELEMENT NOT FOUND !!!"
                : "The index value for " + key_worst + " is : "
                        + Recursive_Bin_Search(nums, 0, nums.length - 1, key_worst));
        System.out.println("\n*****************************************");
    }
}
