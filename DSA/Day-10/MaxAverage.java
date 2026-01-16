public class MaxAverage {
    // Naive Approach: TC = O(n*k) , SC = O(1)
     public static double findMaxAverage(int[] nums, int k) {
        // Ex:- [1, 12, -5, -6, 50, 3], k = 4
        // using naive approach
        // contiguous sum of every k elem and dividing by k 
        // i last idx in outer loop = n - k + 1
        int n = nums.length;
        double maxAvg = Double.NEGATIVE_INFINITY;
        for(int i = 0; i<=n-k; i++){ // O(n)
            int sum = 0;
            for(int j = i; j < i+k; j++){
                sum += nums[j];
            }
            double avg = (double)sum/k;
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
     }

    // Sliding Window Approach: TC = O(n) , SC = O(1)
    public static double findMaxAverageSlidingWindow(int[] nums, int k) {   
        // Sum of first window 
        int windowSum = 0;
        for(int i=0; i<k; i++){
            windowSum += nums[i];
        }

        int maxSum = windowSum;
        // Slide Window
        for(int i=k; i<nums.length; i++){
            windowSum += nums[i]; //add next element
            windowSum -= nums[i-k]; //remove previous element

            maxSum = Math.max(maxSum,windowSum);
        }

        // return average
        return (double)maxSum/k;
    }
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k)); // Output: 12.75
        System.out.println(findMaxAverageSlidingWindow(nums, k)); // Output: 12.75
    }
}
