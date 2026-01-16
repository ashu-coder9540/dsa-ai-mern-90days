public class MinSizeSubArray{
       public static int minSubArrayLen(int target, int[] nums) {
        // Sliding window Approach
        /* Steps
        1. sum from i=0 until sum >= target
        2. remove from start until sum <=target and make a minLen of 
        min size subarray sum
        */
       int n = nums.length;
       int minLength = Integer.MAX_VALUE;
       int windowSum = 0;
       int winSt=0; //windowStart
       for(int winEnd=0; winEnd<n; winEnd++){
            windowSum += nums[winEnd];
        while(windowSum >= target){
            minLength = Math.min(minLength, winEnd - winSt + 1);
            // subtract the first element of window to shrink window
            windowSum -= nums[winSt];
            winSt++;
        }
    }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        System.out.println("Min Size Subarray Length: " + minSubArrayLen(target, arr)); // Output: 2
    }
}