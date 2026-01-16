public class LongestSubStringAtMostK {
    	public static int kDistinctChars(int k, String str) {
		 /* # Longest Substring with at most 2 distinct number
        # Steps
        1. expand window by moving right pointer
        2. put num with freq in map
        3. if distinc number > k:
            ->shrink window by removing left pointer
        4.  keep updating maxLen
         */
        // HashMap<Character, Integer> mp = new HashMap<>();
        int[] freq = new int[26];
        int maxLen = 0;
        int left = 0;
        int n = str.length();
        int distinct = 0;
        for(int right=0; right<n; right++){
            char rightChar = str.charAt(right);
            // mp.put(rightChar, mp.getOrDefault(rightChar, 0) + 1);
            freq[rightChar - 'a']++;

            if(freq[rightChar - 'a'] == 1){
                distinct++;
            }

            // shrink window if map size > k by rmeoving left pointer
            while(distinct > k){
                char leftChar = str.charAt(left);
                // mp.put(leftChar, mp.get(leftChar)-1);
                freq[leftChar - 'a']--;

                // check if curr num freq in map is not 0 if 0 remove it from map
                if(freq[leftChar - 'a']==0){
                    distinct--; 
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
	}
    public static void main(String[] args) {    
        String str = "eceba";
        int k = 2;
        int result = kDistinctChars(k, str);
        System.out.println("Length of the longest substring with at most " + k + " distinct characters: " + result); // Output: 3
    }
}
