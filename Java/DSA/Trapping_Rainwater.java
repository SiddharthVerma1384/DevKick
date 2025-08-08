package DSA;
import java.util.*;
public class Trapping_Rainwater{
    public static int Trapped_Rainwater(int height[]){
        //calculate left maximum - array (Checking for the presence of left boundary for current bar)
        int left_max[] = new int[height.length];
        left_max[0] = height[0];
        for(int i = 1;i<height.length;i++){
            left_max[i] = Math.max(height[i],left_max[i-1]);
        }
        //calculate right maximum - array (Checking for the presence of right boundary for current bar)
        int right_max[] = new int[height.length];
        right_max[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2;i>=0;i--){
            right_max[i] = Math.max(height[i],right_max[i+1]);
        }
        //To calculate trapped rainwater by creating and checking the boundaries
        int rainwater = 0;
        for (int i = 0;i<height.length;i++){
            rainwater += Math.min(left_max[i],right_max[i]) - height[i];
        }

        return rainwater;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int height[] = {4,2,0,6,3,2,5};
        System.out.print("Total trapped rainwater : " + Trapped_Rainwater(height));
    }
}