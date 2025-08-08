package Java;
import java.util.*;
public class Menu_Linear_Search{
    public static int Search_Food(String Food[] ,String choice){
        for(int i = 0;i<Food.length;i++){
            if (Food[i].equals(choice)){
                return i;
            }
        }
        return -1;

    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String menu[] = {"Samosa","Dosa","Paties","Sandwhich","Vada Pav","Pav Bhaji","Soya Chaap"};
        
        System.out.print("Enter your choice you want to eat : ");
        
        String choice = sc.nextLine();
        int index = Search_Food(menu, choice);
        if (index == -1){
            System.out.print("This food item is unavailable here...\nWe are sorry for the inconvinience....");

        }else{
            System.out.print("The "+choice+" is at Sr.no. "+index);
        }
        

    }
}