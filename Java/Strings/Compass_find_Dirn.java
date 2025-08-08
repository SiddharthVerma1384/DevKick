package Strings;
import java.util.*;
public class Compass_find_Dirn{
    public static float Short_Dist(String dir){
        int x=0, y=0;
        for (int i=0; i<dir.length(); i++){
            if (dir.charAt(i) == 'N'){
                y++;
            }else if(dir.charAt(i) == 'S'){
                y--;
            }else if(dir.charAt(i) == 'E'){
                x++;
            }else{
                x--;
            }
        }
        float disp = (float)Math.sqrt((float)Math.pow(x,2) +(float) Math.pow(y,2));
        return disp;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        String compass = "WNEENESENNN";
        System.out.println("Shortest distance : "+Short_Dist(compass)); 
    }
}