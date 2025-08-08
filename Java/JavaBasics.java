
import java.util.Scanner;
class JavaBasics {
    static int getPrecedence(char op) {
        switch (op) {
            case '^': return 3;
            case '*': case '/': return 2;
            case '+': case '-': return 1;
            default: return -1;
        }
    }
    static String reverseAndSwapBrackets(String exp) {
        StringBuilder reversed = new StringBuilder();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch == '(') reversed.append(')');
            else if (ch == ')') reversed.append('(');
            else reversed.append(ch);
        }
        return reversed.toString();
    }
    static String infixToPostfix(String infix) {
        char[] stack = new char[infix.length()];
        int top = -1;
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack[++top] = ch;
            } else if (ch == ')') {
                while (top != -1 && stack[top] != '(') {
                    postfix.append(stack[top--]);
                }
                top--;
            } else {
                while (top != -1 && getPrecedence(stack[top]) >= getPrecedence(ch)) {
                    postfix.append(stack[top--]);
                }
                stack[++top] = ch;
            }
        }
        while (top != -1) postfix.append(stack[top--]);
        return postfix.toString();
    }
    static String infixToPrefix(String infix) {
        String reversed = reverseAndSwapBrackets(infix);
        String postfix = infixToPostfix(reversed);
        return new StringBuilder(postfix).reverse().toString();
    }
    static int evaluatePrefix(String prefix) {
        int[] stack = new int[prefix.length()];
        int top = -1;
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            if (Character.isDigit(ch)) {
                stack[++top] = ch - '0';
            } else {
                int a = stack[top--];
                int b = stack[top--];
                switch (ch) {
                    case '+': stack[++top] = a + b; break;
                    case '-': stack[++top] = a - b; break;
                    case '*': stack[++top] = a * b; break;
                    case '/': stack[++top] = a / b; break;
                    case '^': stack[++top] = (int)Math.pow(a, b); break;
                }
            }
        }
        return stack[top];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine().replaceAll(" ", "");
        String prefix = infixToPrefix(infix);
        int result = evaluatePrefix(prefix);
        System.out.println("\nNAME :- SIDDHARTH VERMA\nROLL NO.:- 24BCB0118\n");

        System.out.println("Prefix: " + prefix);
        System.out.println("Result: " + result);
    }
}
