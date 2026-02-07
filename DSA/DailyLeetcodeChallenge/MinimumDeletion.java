import java.util.Stack;

public class MinimumDeletion {
     public static int minimumDeletions(String s) {
        // 1st approach: Using Stack
        int minDeletion = 0;
        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray()){
            if(!st.empty() && ch == 'a' && st.peek() == 'b'){
                st.pop();
                minDeletion++;
            }else{
                st.push(ch);
            }
        }
        return minDeletion;
    }

    public static int minimumDeletions2(String s) {
        // 2nd Approach: Maintaining a_right_count, b_left_count
        // at each idx
        // T.C = O(n)
        // S.C = O(n)
        int n = s.length();
        int[] a_right = new int[n];
        int[] b_left  = new int[n];

        int b_count = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            b_left[i] = b_count;
            if(ch == 'b') b_count++;
        }

        int a_count = 0;
        for(int i=n-1; i>=0; i--){
            char ch = s.charAt(i);
            a_right[i] = a_count;
            if(ch == 'a') a_count++;
        }

        int minDeletion = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            minDeletion = Math.min(minDeletion, b_left[i] + a_right[i]);
        }
        return minDeletion;
    }

    public static int minimumDeletions3(String s) {
        // 3rd Approach: count total a and decr a_count whenever a encountered 
        // and increase count_b whenever b encountered
        int n = s.length();

        int a_count = 0;
        for(int i=0; i<n; i++){
           char currCh = s.charAt(i);
           if(currCh == 'a') a_count++;
        }

        int minDeletion = Integer.MAX_VALUE;
        int b_count = 0;
        for(int i=0; i<n; i++){
            char currCh = s.charAt(i);
            if(currCh == 'a') a_count--;
            minDeletion = Math.min(minDeletion, b_count + a_count);
            if(currCh == 'b') b_count++;
        }
        return minDeletion;
    }

    public static int minimumDeletions4(String s) {
        // 4th Approach: count total a and decr a_count whenever a encountered 
        // and increase count_b whenever b encountered
        int n = s.length();

        int a_count = 0;
        for(int i=0; i<n; i++){
           char currCh = s.charAt(i);
           if(currCh == 'a') a_count++;
        }

        int minDeletion = Integer.MAX_VALUE;
        int b_count = 0;
        for(int i=0; i<n; i++){
            char currCh = s.charAt(i);
            if(currCh == 'a') a_count--;
            minDeletion = Math.min(minDeletion, b_count + a_count);
            if(currCh == 'b') b_count++;
        }
        return minDeletion;
    }
    public static void main(String[] args) {
        String s = "aababbab";
        int minDeletion = minimumDeletions(s);
        System.out.println(minDeletion); // O/P: 2

        int minDeletion2 = minimumDeletions2(s);
        System.out.println(minDeletion2);  // O/P: 2

        int minDeletion3 = minimumDeletions3(s);
        System.out.println(minDeletion3);  // O/P: 2

        int minDeletion4 = minimumDeletions4(s);
        System.out.println(minDeletion4); // O/P: 2
    }
}
