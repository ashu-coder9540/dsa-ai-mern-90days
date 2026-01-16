public class MaxSumSubArray {
    public static int maxSubarraySum(int[] arr, int k) {
        // Naive Approach
        // Steps
        /*
         * get sum of every k element and get max out of it
         */
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum; // time complexity = O(N*K), Space complexity = O(1)
    }

    public static int maxSubarraySumSlidingWindow(int[] arr, int k) {
        // Sliding Window Approach
        // Steps
        /*
         * 1. get sum of first k elements
         * 2. slide the window by removing first element of previous window and adding
         * next element of current window
         * 3. update maxSum if current window sum is greater than maxSum
         */
        // first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        int n = arr.length;
        for (int i = k; i < n; i++) {
            windowSum += arr[i]; // add next element
            windowSum -= arr[i - k]; // remove prev element

            // update maxSum
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum; // time complexity = O(n), space complexity = O(1)
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        System.out.println("Max Subarray Sum (Naive): " + maxSubarraySum(arr, k)); // Output: 9
        System.out.println("Max Subarray Sum (Sliding Window): " + maxSubarraySumSlidingWindow(arr, k)); // Output: 9
    }
}
