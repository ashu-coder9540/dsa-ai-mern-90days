import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
     public static int lengthOfLongestSubstring(String s) {
      /* #Steps
      1. we can use hashmap to store freq of duplicate char in string
      2. then trave in hashmap and whenever we get duplicate we can move left pointer where last duplicated seen above but that in the range 
      3. keep updating maxLength of Longest Substring Without Repeating Characters
       */
       HashMap<Character, Integer> mp = new HashMap<>();
       int n = s.length();
       int maxLength = 0;
       int winStart = 0;
       for(int winEnd=0; winEnd<n; winEnd++){
        char ch = s.charAt(winEnd);
    //    if char is already seen move left pointer
        if(mp.containsKey(ch)){
            winStart = Math.max(winStart, mp.get(ch)+1);
        }
    //  update last seen idx char
        mp.put(ch, winEnd);

    //  update maxLength
        maxLength = Math.max(maxLength, winEnd - winStart + 1);
       }
       return maxLength;
    }   
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + result); // Output: 3
    }
}
