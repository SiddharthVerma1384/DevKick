
import java.util.*;
class Calculator{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter A : ");
        float A = sc.nextFloat();
        System.out.print("Enter B : ");
        float B = sc.nextFloat();
        System.out.print("Entry conditions :-\n+ -> Addition\n- -> Subtraction\n*-> Multiplication\n/ -> Division\nNow enter your choice according to the given cases:-");
        char choice = sc.next().charAt(0);
        switch(choice){
            case '+': System.out.println("Addition is : " + (A + B) );
                break;
            case '-': System.out.println("Subtraction is : " + (A - B) );
                break;
            case '*': System.out.println("Multiplication is : " + (A * B) );
                break;
            case '/': System.out.println("Division is : " + (A / B) );
                break;
            default : System.out.println("Choose according to given choices.");
        }
    }
}
