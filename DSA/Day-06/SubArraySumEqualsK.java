import java.util.HashMap;

public class SubArraySumEqualsK {
    // Using HashMap
    static int subArraySum(int[] arr, int k){
       HashMap<Integer, Integer> map = new HashMap<>(); //Space Complexity: O(n)
       int maxLength = 0;
       int prefixSum = 0;
       int n = arr.length;
       for(int i=0; i<n; i++){ // Time Complexity: O(n)
            prefixSum += arr[i];
            if(prefixSum == k){
                maxLength = Integer.max(maxLength, i+1);
            }
            int rem = prefixSum - k;
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLength = Integer.max(maxLength, len);
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
       }
         return maxLength;
    }
    // Using 2 Pointer Approach
    static int subArraySum2(int[] arr, int k){
        int n = arr.length;
        int left = 0, right = 0;
        int sum = 0;
        int maxLength = 0;
        while(right < n){
            if(right < n) sum += arr[right];
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                maxLength = Integer.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {2,0,0,3};
        int k = 3;
        int result = subArraySum2(arr, k);
        System.out.println("Max Length of subarray with sum " + k + " is " + result);
    } 
}
