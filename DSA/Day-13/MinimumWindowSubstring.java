public class MinimumWindowSubstring {
     public static String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        //  Build empty 128 size freq array
        int[] freq = new int[128];
        //  count t char freq in freq array
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }
        int l = 0, r = 0, req = t.length(), minLen = Integer.MAX_VALUE, start = 0;

        while (r < s.length()) {
            char rc = s.charAt(r);
            // include current character
            if (freq[rc] > 0)
                req--;
            freq[rc]--;
            r++;
            //  if all character included in current substring
            while (req == 0) {
                if (r - l < minLen) {
                    minLen = r - l;
                    start = l;
                }
                char lc = s.charAt(l);
                // remove left char from curr window and restore their freq 
                freq[lc]++;
                if (freq[lc] > 0)
                    req++;
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t)); // Output: "BANC"
    }
}
