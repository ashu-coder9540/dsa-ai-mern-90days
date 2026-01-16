import java.util.Stack;

public class ValidParentheses {
// Stack Approach: TC = O(n) , SC = O(n)
    public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for(char ch: s.toCharArray()){
        // push opening brackets
        if(ch=='(' || ch=='[' || ch=='{'){
            stack.push(ch);
        }
        // Handle closing brackets
        else{
            if(stack.isEmpty()) return false;
            char top = stack.pop();

            if ((ch == ')' && top != '(') ||
                 (ch == '}' && top != '{') ||
                 (ch == ']' && top != '[')) {
                 return false;
            }
        }
    }
    return stack.isEmpty();
    }

// stack using array approach: TC = O(n) , SC = O(n)
    public static boolean isValidWithoutStack(String s) {
       
        char[] stack = new char[s.length()];  // stack using array
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // opening brackets → push
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch;
            }

            // closing brackets → pop and check
            else if (ch == ')' || ch == '}' || ch == ']') {

                // no opening bracket
                if (top == -1) return false;

                // mismatch check
                if ((ch == ')' && stack[top] != '(') ||
                    (ch == '}' && stack[top] != '{') ||
                    (ch == ']' && stack[top] != '[')) {
                    return false;
                }

                top--; // pop
            }
        }

        // balanced if stack empty
        return top == -1;
    }
    public static void main(String[] args) {
        String s = "[()]}";
        System.out.println(isValid(s)); // Output: false
    }
}