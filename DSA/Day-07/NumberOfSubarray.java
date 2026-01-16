import java.util.HashMap;

public class NumberOfSubarray {
    // Approach 1: Brute Force, using nested loops
    static int countSubarrays(int[] arr, int k) {
      int count = 0;
      int n = arr.length;
      for(int i=0; i<n; i++){ // Time Complexity: O(n^2)
        int sum = 0;
        for(int j=i; j<n; j++){
            sum += arr[j];
            if(sum == k) count++;
        }
      }
      return count;
    }
    // Approach 2: Using HashMap (Prefix Sum)
    static int countSubarrays2(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Space Complexity: O(n)
        int count = 0;
        int prefSum = 0;
        int n = arr.length;
        map.put(0,1); // To handle the case when prefix sum itself is equal to k
        // Time Complexity: O(n*logn) due to HashMap operations
        for(int i=0; i<n; i++){
            prefSum += arr[i];
            int rem = prefSum - k;
            if(map.containsKey(rem)){
                count += map.get(rem);                                                                                                                              
            }
            map.put(prefSum, map.getOrDefault(prefSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1};
        int k = 3;
        int result = countSubarrays(arr, k);
        System.out.println("Number of subarrays with sum " + k + " is " + result);
    }
}
