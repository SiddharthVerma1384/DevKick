package DSA_VIT.Stack_And_Applications;
import java.util.*;
public class BalancedParenthesis {
    public static boolean matching(char open, char close){
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
    public static String ExprCheck(String expr){
        char stack[] = new char[expr.length()];
        int top = -1;
        boolean MisMatch = false;
        int extraClose = 0;
        for (char ch : expr.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                stack[++top] = ch;
            }else if(ch == ')' || ch == '}' || ch == ']'){
                if (top == -1){
                    extraClose ++;
                }else{
                    char open = stack[top--];
                    if (!matching(open, ch)) MisMatch = true;
                }
            }
        }
        if (top != -1) return "Missing Parenthesis";
        if (extraClose > 0) return "Extra Parenthesis";
        if(MisMatch) return "Type Mismatch";
        return "Balanced";
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String tests[] = {"(a+b) * {c+d}", "(a+b) * {c+d]", "((a+b) * (c+d)","(a+b)) + (c+d)"};

        for (String test : tests){
            System.out.println("Expr: "+test);
            System.out.println("Result: " + ExprCheck(test));
            
        }
    }
}