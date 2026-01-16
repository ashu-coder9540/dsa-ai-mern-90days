import java.util.HashMap;

public class SubarraySumDivK {
    // Using Brute Force: using nested loops
    static int subarraySumDivK(int[] arr, int k) {
        // Similar to the previous problem, but we're looking for subarrays whose sum is divisible by k
        int res = 0;
        int n = arr.length;
        // Space Complexity: O(1)
        for(int i = 0; i < n; i++) { // Time Complexity: O(n^2)
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr[j];
                if(sum % k == 0)
                    res = Integer.max(res, j - i + 1);
            }
        }
        return 0;
    }
    // Using HashMap (Prefix Sum)
    static int subarraySumDivK2(int[] arr, int k) {
        HashMap<Integer, Integer> remMap = new HashMap<>(); // Space Complexity: O(n)
        int maxLen = 0;
        long prefSum = 0;
        int n = arr.length;
        remMap.put(0, -1); // To handle the case when prefix sum itself is divisible by k
        // Time Complexity: O(n*logn) due to HashMap operations
        for(int i=0; i<n; i++){
            prefSum += arr[i];
            int rem = (int)(prefSum % k);

            if(rem < 0) rem += k; // Handle negative remainders

            if(remMap.containsKey(rem)){
                int len = i - remMap.get(rem);
                maxLen = Math.max(maxLen, len);
            } else {
                remMap.put(rem, i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {-2, 2, -5, 12, -11, -1, 7};
        int k = 3;
        int result = subarraySumDivK2(arr, k);
        System.out.println("Max Length of subarray with sum divisible by " + k + " is " + result);
    }
}
