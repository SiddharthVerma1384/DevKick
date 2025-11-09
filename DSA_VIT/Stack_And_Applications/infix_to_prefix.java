package DSA_VIT.Stack_And_Applications;
import java.util.*;
public class infix_to_prefix {
    static int precedence(char op){
        switch(op){
            case '^' : return 3;
            case '*' : case '/' : return 2;
            case '+' : case '-' : return 1;
            default : return -1;
        }
    }
    static String reverseAndSwapBrackets(String exp){
        StringBuilder reversed = new StringBuilder();
        for (int i=exp.length()-1; i>=0; i--){
            char ch = exp.charAt(i);
            if (ch == '(') reversed.append(')');
            else if (ch == ')') reversed.append('(');
            else reversed.append(ch);
        }
        return reversed.toString();
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
    static String infixToPrefix(String infix){
        String reversed = reverseAndSwapBrackets(infix);
        String postfix = convertToPostfix(infix);
        return new StringBuilder(postfix).reverse().toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix Exp : ");
        String Infix = sc.nextLine().replaceAll(" ", "");
        String prefix = infixToPrefix(Infix);
        System.out.println("Prefix : " + prefix);
    }
}
