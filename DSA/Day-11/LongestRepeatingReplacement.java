public class LongestRepeatingReplacement {
     /* #Steps
        1. expand window by moving right pointer
        2. put char with freq in map
        3. calculate maxFreq of char in current window
        4. if (window size - maxFreq) > k:
            ->shrink window by removing left pointer
        5.  keep updating maxLen
         */
    public static int characterReplacement(String s, int k) {
       int[] freq = new int[26];
       int maxLen=0;
       int maxFreq=0;
       int l=0;
       int r=0;
       int n=s.length();
       while(r<n){
        char rightChar = s.charAt(r);
        freq[rightChar - 'A']++;

        maxFreq = Math.max(maxFreq, freq[rightChar - 'A']);
        int replacement = (r - l + 1) - maxFreq;
        
        if(replacement > k){
        // remove left char freq from freq map
            char leftChar = s.charAt(l);
            freq[leftChar - 'A']--;
            l++;
        }
        // if replacement <= k
        maxLen = Math.max(maxLen, r - l + 1);
        r++;
       }
       return maxLen;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int result = characterReplacement(s, k);
        System.out.println("Length of the longest substring after replacement: " + result); // Output: 4   
    }
}
