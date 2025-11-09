package DSA_VIT.Stack_And_Applications;
import java.util.*;
public class infix_to_postfix {
    static int precedence(char op){
        switch(op){
            case '^' : return 3;
            case '*' : case '/' : return 2;
            case '+' : case '-' : return 1;
            default : return -1;
        }
    }
    static String convertToPostfix(String infix){
        char stack[] = new char[infix.length()];
        int top = -1;
        StringBuilder postfix = new StringBuilder();
        for (int i=0; i<infix.length(); i++){
            char ch = infix.charAt(i);
            if (Character.isDigit(ch)){
                postfix.append(ch);
            }else if(ch == '('){
                stack[++top] = ch;
            }else if(ch == ')'){
                while (top != -1 && stack[top] != '('){
                    postfix.append(stack[top--]);
                }
                top --;
            }else {
                while (top != -1 && precedence(stack[top]) >= precedence(ch)){
                    postfix.append(stack[top--]);
                }
                stack[++top] = ch;
            }
        }

        while (top != -1){
            postfix.append(stack[top--]);
        }
        return postfix.toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix Exp : ");
        String Infix = sc.nextLine().replaceAll(" ", "");
        String postfix = convertToPostfix(Infix);
        System.out.println("Postfix : " + postfix);
    }
}