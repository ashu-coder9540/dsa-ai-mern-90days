import java.util.HashMap;
import java.util.Map;

public class FruitsIntobaskets {
     public static int totalFruit(int[] fruits) {
        /* # Longest Substring with at most 2 distinct number
        # Steps
        1. expand window by moving right pointer
        2. put num with freq in map
        3. if distinc number > 2:
            ->shrink window by removing left pointer
        4.  keep updating maxLen
         */
        Map<Integer, Integer> mp = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int n = fruits.length;
        for(int right=0; right<n; right++){
            int rightNum = fruits[right];
            mp.put(rightNum, mp.getOrDefault(rightNum, 0) + 1);

            // shrink window if map size > 2 by rmeoving left pointer
            while(mp.size() > 2){
                int leftNum = fruits[left];
                mp.put(leftNum, mp.get(leftNum)-1);

                // check if curr num freq in map is not 0 if 0 remove it from map
                if(mp.get(leftNum)==0){
                    mp.remove(leftNum);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    //  Longest Substring with At Most Two Distinct Characters
    public static int lengthOfLongestSubstring(String s) {
		// Write your code here.
		HashMap<Character, Integer> mp = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int n = s.length();
        for(int right=0; right<n; right++){
            char rightChar = s.charAt(right);
            mp.put(rightChar, mp.getOrDefault(rightChar, 0) + 1);

            // shrink window if map size > 2 by rmeoving left pointer
            while(mp.size() > 2){
                char leftChar = s.charAt(left);
                mp.put(leftChar, mp.get(leftChar)-1);

                // check if curr num freq in map is not 0 if 0 remove it from map
                if(mp.get(leftChar)==0){
                    mp.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
	}
    public static void main(String[] args) {
        int[] fruits = {1,2,1,2,3,2,2,1};
        int result = totalFruit(fruits);
        System.out.println("Maximum number of fruits that can be collected: " + result); // Output: 4, picking fruits [2,3,2,2]

        String s = "ninninja";
        int lengthResult = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring with at most 2 distinct characters: " + lengthResult); // Output: 3
    }
}
