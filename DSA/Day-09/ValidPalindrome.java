import java.util.Stack;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
     //   Bruteforce Approach: TC:- O(n), SC:- O(n)
    // clean the string
    StringBuilder cleaned = new StringBuilder();
    int n = s.length();
    for(int i=0; i<n; i++){
        char ch = s.charAt(i);
    // convert everything into lowercase
        if(Character.isLetterOrDigit(ch))
            cleaned.append(Character.toLowerCase(ch));
    }
    // Reverse the cleaned string
    String original = cleaned.toString();
    String reverse = cleaned.reverse().toString();

    return original.equals(reverse);
}
public static boolean isPalindromeStack(String s) {
     // Stack Approach: TC = O(n) , SC = O(n)
    StringBuilder sb = new StringBuilder();
    int n = s.length();
    
    for(int i=0; i<n; i++){
        char ch = s.charAt(i);
        // clean string and convert everything into lowercase
        if(Character.isLetterOrDigit(ch))
            sb.append(Character.toLowerCase(ch));
    }
    String str = sb.toString();
    int len = str.length();
        // use Stack
    Stack<Character> st = new Stack<>();
    // Push first half of character in stack
    for(int i=0; i<len/2; i++){
        char ch = str.charAt(i);
        st.push(ch);
    }

    // Start comparing arr elements with stack top
    int start = (len%2 == 0) ? len/2 : len/2 + 1;

    for(int i=start; i<len; i++){
        if(st.pop() != str.charAt(i))
            return false;
    }
    return true;

}
    public static boolean isPalindromeTwoPointer(String s) {
       int l = 0;
    int r = s.length()-1;

    while(l < r){
        // Skip non alphanumeric characters
        while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
            l++;
        }
         while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
            r--;
        }

        if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
            return false;
        }
        l++;
        r--;
    }
    return true;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s)); // Output: true    
        System.out.println(isPalindromeStack(s)); // Output: true    
        System.out.println(isPalindromeTwoPointer(s)); // Output: true
    }
}
