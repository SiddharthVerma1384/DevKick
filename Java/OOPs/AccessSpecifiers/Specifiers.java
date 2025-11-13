package OOPs.AccessSpecifiers;
import java.util.*;
class BankAccount{
    String Username;
    private String password;

    void setPassword(String pass){
        password = pass;
    }
}
public class Specifiers {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BankAccount myAcc = new BankAccount();
        myAcc.Username = "Siddharth Verma"; // No specifier given so it is a default specefier 
        // myAcc.password = "Rs@123";  //Cannot be accessed outside the class as it is private data
        myAcc.setPassword("Sher");

    }
}