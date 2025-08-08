
import java.util.*;
class Sum_Digits{
    public static int Sum_Digits(int num){
        int sum = 0;
        while (num>0){
            int last_digit = num % 10;
            sum+=last_digit;
            num/=10;
        }
        return sum;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer : ");
        int num = sc.nextInt();
        System.out.print("Sum of the digits : "+Sum_Digits(num));
    }
}
