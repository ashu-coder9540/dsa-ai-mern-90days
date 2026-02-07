public class StringPermutation {
     private static boolean matches(int[] a, int[] b){
        for(int i=0; i<26; i++){
        if(a[i]!=b[i]){
            return false;
        }
        }
        return true;
    }
    public static boolean checkInclusion(String s1, String s2) {
        // base case
        if(s1.length()>s2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // count freq of s1 char
        for(char ch: s1.toCharArray()){
            freq1[ch-'a']++;
        }

        int k = s1.length();

        // create 1st window of s2 string
        for(int i=0; i<k; i++){
            freq2[s2.charAt(i)-'a']++;
        }

        // check 1st window matches with permutation of s1 char
        if(matches(freq1, freq2)) return true;

        // slide window
        for(int i=k; i<s2.length(); i++){
            freq2[s2.charAt(i)-'a']++; // add new char

            freq2[s2.charAt(i-k)-'a']--; //remove old char

            if(matches(freq1, freq2)) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = checkInclusion(s1, s2);
        System.out.println("Does s2 contain a permutation of s1? " + result); // Output: true
    }
}
