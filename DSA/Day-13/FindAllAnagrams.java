import java.util.*;


public class FindAllAnagrams {
     public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
       
        if (s.length() < p.length()) return res;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

    // count freq of p string char
        for(char ch: p.toCharArray()){
            freq1[ch - 'a']++;
        }
        int k = p.length();
    // sliding window on s char
        for(int i=0; i<s.length(); i++){
            // add curr char
            freq2[s.charAt(i)-'a']++;
            // remove char that goes out of window
            if(i>=k){
                freq2[s.charAt(i-k)-'a']--;
            }
            // Compare both freq arr
            if(Arrays.equals(freq1, freq2)){
                res.add(i-k+1);
            }
        }
        return res;
    }
     public static List<Integer> findAnagramsOptimized(String s, String p) {
       List<Integer> ans = new ArrayList<>();

       if(s.length()<p.length()) return ans;
       int[] freq = new int[26];
    //    store freq of p
       for(char ch: p.toCharArray()){
        freq[ch-'a']++;
       }

       int l=0, r=0, req=p.length();

    //    sliding window
    while(r<s.length()){
        char ch = s.charAt(r);

        // If char is needed, reduce required
        if(freq[ch-'a']>0){
            req--;
        }
        freq[ch-'a']--;
        r++;
        // If window size == p.length()
        if(r-l == p.length()){
            if(req==0){
                ans.add(l);
            }
             char leftChar = s.charAt(l);
            // Restore freq while shrinking window
            if(freq[leftChar-'a']>=0){
                req++;
            }
            freq[leftChar-'a']++;
            l++;
        }
    }
    return ans;
    }
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        List<Integer> resultOptimized = findAnagramsOptimized(s, p);
        System.out.println("Starting indices of anagrams of p in s: " + result); // Output: [0, 6]
        System.out.println("Starting indices of anagrams of p in s (optimized): " + resultOptimized); // Output: [0, 6]
    }
}
