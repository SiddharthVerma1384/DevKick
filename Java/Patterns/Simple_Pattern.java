package Patterns;
import java.util.*;
public class Simple_Pattern{
    public static void Star_Pattern(int n){

        for(int i = 1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void Inv_Star_Pattern(int n){
        for(int i = 1;i<=n;i++){
            for(int j =1;j<=(n-i)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void Half_Pyramid_No_Pattern(int n){
        for(int i =1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void Character_Pattern(int n){
        char ch = 'A';
        for(int i =1;i<=n;i++){
            for(int j =1;j<=i;j++){
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }
    public static void Character_Pattern_2(int n){
        for(int i =1;i<=n;i++){
            char ch = 'A';
            for(int j=1;j<=i;j++){
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of lines you want to get your Pattern : ");
        int n = sc.nextInt();
        System.out.print("\nChoose your pattern type:-\n1 -> for Star Pattern.\n2 -> for Inverted Star Pattern.\n3 -> for Half Pyramid Number Pattern.\n4 -> for Character Pattern.\n5 -> for Character Pattern 2.\n\nEnter your choice according to above criteria only. :: ");
        int choice = sc.nextInt();
        switch(choice){
            case 1: System.out.println("\nYour desired pattern :-\n\nStar Pattern :--");
                    Star_Pattern(n);
                break;
            case 2: System.out.println("\nYour desired pattern :-\n\nInverted Star Pattern :--");
                    Inv_Star_Pattern(n);
                break;
            case 3: System.out.println("\nYour desired pattern :-\n\nHalf Pyramid Number Pattern :--");
                    Half_Pyramid_No_Pattern(n);
                break;
            case 4: System.out.println("\nYour desired pattern :-\n\nCharacter Pattern :--");
                    Character_Pattern(n);
                break;
            case 5: System.out.println("\nYour desired pattern :-\n\nCharacter Pattern 2 :--");
                    Character_Pattern_2(n);
                break;
            default: System.out.println("\nChoose the options accordingly only....");
        }
    }
}