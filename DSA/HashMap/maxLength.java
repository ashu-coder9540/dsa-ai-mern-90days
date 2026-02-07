import java.util.*;

public class maxLength {
    static int zeroSumSubArray(int[] nums){
            int n = nums.length;
            int maxLength = 0, prefSum = 0;
            HashMap<Integer, Integer> mp = new HashMap<>();
            mp.put(0, -1);
            for(int i=0; i<n; i++){
                prefSum += nums[i];
                if(mp.containsKey(prefSum)){
                    maxLength = Math.max(maxLength, i-mp.get(prefSum));
                }
                mp.put(prefSum,i);
            }
            return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int maxLen = zeroSumSubArray(arr);
        System.out.println(maxLen);
    }
}
