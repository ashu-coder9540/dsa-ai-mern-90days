import java.util.HashMap;
import java.util.Map;

public class LongestSubStringKUnique {
      public static int longestKSubstr(String s, int k) {
        /* #Approach
        1. left -> start of window
        2. right -> end of window
        3. HashMap<Character, Integer> → character frequency in current window
        */
        /* #Steps
        1. Expand window by moving right
        2. Add current character to map
        3. If distinct characters > k
            → shrink window by moving left
        4. Keep updating maximum window size
        */
        // Sliding Window
        
        if(s == null || k == 0) return 0;
        
        Map<Character, Integer> mp = new HashMap<>();
        
        int left = 0, maxLen = -1;
        
        for(int right=0; right<s.length(); right++){
            char rightChar = s.charAt(right);
            mp.put(rightChar, mp.getOrDefault(rightChar, 0)+1);
            
            // Shrink window if distinct characters > k
            while(mp.size()>k){
                char leftChar = s.charAt(left);
                mp.put(leftChar, mp.get(leftChar)-1); // reduce freq 
                
                if(mp.get(leftChar) == 0){
                    mp.remove(leftChar);
                }
                left++;
            }
            // update only when exactly k distinct
            if(mp.size()==k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        int result = longestKSubstr(s, k);
        System.out.println("Length of the longest substring with " + k + " unique characters: " + result); // Output: 7
    }
}
