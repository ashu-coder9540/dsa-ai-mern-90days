import java.util.HashMap;

public class ValidAnagram {
     public static boolean isAnagram(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()) return false;

        // put all ch from s with their freq
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        // Now check for t 
        for(char c: t.toCharArray()){
            // if char is not present in map
            if(!map.containsKey(c)){
                return false;
            }
            // reduce freq if char exists in map
            else{
                map.put(c, map.get(c) - 1);
            }
            // if freq of curr char is 0 remove from map
            if(map.get(c) == 0){
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t)); // Output: true
    }
}
