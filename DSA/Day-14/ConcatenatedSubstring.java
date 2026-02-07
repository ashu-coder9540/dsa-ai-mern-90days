import java.util.*;
public class ConcatenatedSubstring {
     public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return ans;

        int wordLen = words[0].length();
        int totalWords = words.length;
        // int windowSize = wordLen * totalWords;

        HashMap<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // Try all possible starting points (0 to wordLen-1)
        for (int start = 0; start < wordLen; start++) {

            HashMap<String, Integer> seen = new HashMap<>();
            int left = start, count = 0;

            for (int right = start; right <= s.length() - wordLen; right += wordLen) {

                String word = s.substring(right, right + wordLen);

                // If word exists in words[]
                if (freq.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // If word frequency exceeded → shrink window
                    while (seen.get(word) > freq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If valid window found -> add it to ans
                    if (count == totalWords) {
                        ans.add(left);
                    }

                } else {
                    // Reset window
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s, words)); // Output: [0, 9]
    }
}
