
import java.util.*;
class Advanced_Pattern{
    public static void Hollow_Rectangle(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==1 || i==n || j==1 || j==n ){
                    System.out.print("*"+" ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void Inv_Rotated_Half_Pyramid(int n){
        for(int i =1;i<=n;i++){
            for(int j =n;j>=1;j--){
                if (j<=i){
                    System.out.print("*"+" ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void Inv_Half_Pyramid_Nos(int n){
        for(int i =1;i<=n;i++){
            for(int j =1;j<=(n-i)+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void Floyd_Triangle(int n){
        int num = 1;
        for(int i =1;i<=n;i++){
            for (int j =1;j<=i;j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }
    public static void Puzzle_0_1_Triangle(int n){
        for(int i =1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j) % 2 == 0){
                    System.out.print("1"+" ");
                }else{
                    System.out.print("0"+" ");
                }
            }
            System.out.println();
        }
    }
    public static void Butterfly_Pattern(int n){
        for(int i = 1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*"+" ");
            }
            for(int j =1;j<=2*(n-i);j++){
                System.out.print("  ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
        for(int i = n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*"+" ");
            }
            for(int j =1;j<=2*(n-i);j++){
                System.out.print("  ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
    public static void Solid_Rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void Hollow_Rhombus(int n){
        for (int i =1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=n;j++){
                if(i==1 || i==n || j==1 || j==n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void Diamond_Pattern(int n){
         for (int i =1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
         for (int i =n;i>=1;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void Number_Pyramid_Pattern(int n){
        for(int i =1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void Palindromic_Pattern_Number(int n){
        for(int i=1;i<=n;i++){
            for(int j =1;j<=(n-i);j++){
                System.out.print("  ");
            }
            for(int j =i;j>=1;j--){
                System.out.print(j+" ");
            }
            for(int j =2;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of lines you want to get your Pattern : ");
        int n = sc.nextInt();
        System.out.print("\nChoose your pattern type:-\n1 -> for Hollow Rectangle.\n2 -> for Inverted Rotated Half Pyramid.\n3 -> for Inverted Half Pyramid Number.\n4 -> for Floyd's Triangle.\n5 -> for 0 & 1 Triangle.\n6 -> for Butterfly Pattern.\n7 -> for Solid Rhombus.\n8 -> for Hollow Rhombus.\n9 -> for Diamond Pattern.\n10 -> for Number Pyramid Pattern.\n11 -> for Palindromic Pattern Number.\n\nEnter your choice according to above criteria only. :: ");
        int choice = sc.nextInt();
        switch(choice){
            case 1: System.out.println("\nYour desired pattern :-\n\nHollow Rectangle :--");
                    Hollow_Rectangle(n);
                break;
            case 2: System.out.println("\nYour desired pattern :-\n\nInverted Rotated Half Pyramid :--");
                    Inv_Rotated_Half_Pyramid(n);
                break;
            case 3: System.out.println("\nYour desired pattern :-\n\nInverted Half Pyramid Pattern :--");
                    Inv_Half_Pyramid_Nos(n);
                break;
            case 4: System.out.println("\nYour desired pattern :-\n\nFloyd's Triangle :--");
                    Floyd_Triangle(n);
                break;
            case 5: System.out.println("\nYour desired pattern :-\n\n0 & 1 Triangle :--");
                    Puzzle_0_1_Triangle(n);
                break;
            case 6: System.out.println("\nYour desired pattern :-\n\nButterfly Pattern :--");
                    Butterfly_Pattern(n);
                break;
            case 7: System.out.println("\nYour desired pattern :-\n\nSolid Rhombus :--");
                    Solid_Rhombus(n);
                break;
            case 8: System.out.println("\nYour desired pattern :-\n\nHollow Rhombus :--");
                    Hollow_Rhombus(n);
                break;
            case 9: System.out.println("\nYour desired pattern :-\n\nDiamond Pattern :--");
                    Diamond_Pattern(n);
                break;
            case 10: System.out.println("\nYour desired pattern :-\n\nNumber Pyramid Pattern :--");
                     Number_Pyramid_Pattern(n);
                break;
            case 11: System.out.println("\nYour desired pattern :-\n\nPalindromic Pattern Number :--");
                     Palindromic_Pattern_Number(n);
                break;
            default: System.out.println("\nChoose the options accordingly only....");
        }
    }
}
