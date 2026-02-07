public class MaxConsecutiveOnes {
      public static int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int zeros = 0;
            for(int j=i; j<n; j++){
                if(nums[j]==0){
                    zeros++;
                }
                if(zeros<=k){
                    int len = j-i+1;
                    maxLen = Math.max(maxLen, len);
                }else{
                    break;
                }
            }
        }
        return maxLen;
    }
    public static int longestOnesOptimized(int[] nums, int k) {
        // Optimized approach
    int l=0;
    int r=0;
    int maxLen=0;
    int zerosCount=0;
    int n=nums.length;
    while(r<n){
        if(nums[r]==0){
            zerosCount++;
        }
        // while(zerosCount>k){
        if(zerosCount>k){ //best approach
            if(nums[l]==0) zerosCount--;
            l++;
        }
        if(zerosCount<=k){
            int len = r-l+1;
            maxLen = Math.max(maxLen, len);
        }
        r++;
    }
    return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int result = longestOnesOptimized(nums, k);
        System.out.println("Maximum consecutive ones after flipping at most " + k + " zeros: " + result); // Output: 6
    }
}
