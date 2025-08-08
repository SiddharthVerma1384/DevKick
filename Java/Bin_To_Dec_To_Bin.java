
import java.util.*;
class Bin_To_Dec_To_Bin{
    public static int Bin_To_Dec(int bin){
        int last_digit = 0;
        int dec = 0;
        int pow = 0;
        while (bin>0){
            last_digit = bin % 10;
            dec = dec + (last_digit * (int)Math.pow(2,pow));
            pow++;
            bin = bin/10;
        }
        return dec;
    }
    public static int Dec_To_Bin(int dec){
        int bin = 0;
        int rem = 0;
        int pow = 0;
        while(dec>0){
            rem = dec % 2;
            bin = bin + (rem * (int)Math.pow(10,pow));
            pow++;
            dec = dec/2;
        }
        return bin;
    }
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter:-\n1:-> for binary to decimal conersion.\n2:-> for decimal to binary conversion.\nEnter your choice according to your above need : ");
        int choice = sc.nextInt();
        switch(choice){
            case 1 :
                System.out.print("Enter a binary no. : ");
                int bin = sc.nextInt();
                System.out.print("The decimal of "+bin+" is : "+Bin_To_Dec(bin));
                break;
            case 2:
                System.out.print("Enter a decimal no. : ");
                int dec = sc.nextInt();
                System.out.print("The binary of "+dec+" is : "+Dec_To_Bin(dec));
                break;
            default: System.out.print("Enter your choice according to the given conditions only....");
                break;
        }
    }
}
