import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i <= n - k; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                maxVal = Math.max(maxVal, nums[j]);
            }
            ans[idx++] = maxVal;
        }
        return ans;
    }
    public static int[] maxSlidingWindow2(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];

        Deque<Integer> dq = new LinkedList<>();
        int idx = 0;

        for(int i=0; i<n; i++){

            // 1. Remove out of window elements
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            // 2. Remove smaller elements from back
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }

            // 3. Add current index
            dq.addLast(i);

            // 4. Add to answer when window formed
            if(i >= k-1){
                ans[idx++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow2(nums, k);
        System.out.println(Arrays.toString(result)); // Output: [3, 3, 5, 5, 6, 7]
    }
}
