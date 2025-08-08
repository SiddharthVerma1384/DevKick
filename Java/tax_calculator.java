
import java.util.*;
class tax_calculator{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter your income : ");
        int income = sc.nextInt();
        if (income < 500000){
            System.out.println("You have to pay no tax.");
        }else if((income > 500000) && (income < 1000000)){
            System.out.println("You have to pay Rs."+ (0.2 * income) + " as tax.");
        }else{
            System.out.println("You have to pay Rs."+ (0.3 * income) + " as tax.");
        }
    }
}
