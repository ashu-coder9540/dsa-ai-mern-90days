import java.util.*;
public class TwoSum {
     public static int[] twoSum(int[] nums, int target){
        int n = nums.length;
        // Optimal Approach using hashmap
        HashMap<Integer,Integer> map = new HashMap<>(); // SC = O(n)
        for(int i=0; i<n; i++){ // TC = O(n)
            int comp = target - nums[i];

            if(map.containsKey(comp)){
                return new int[] {map.get(comp), i};
            }else{
                map.put(nums[i],i);
            }
        }
        //If no index found after traversing whole array return empty array
        return new int[] {};
    }  
    // if array is sorted -> Binary Search 
    public static int[] twoSumSorted(int[] nums, int target){
        int left = 0, right = nums.length - 1; // TC = O(n), SC = O(1)

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[] {left, right};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // Output: [0, 1]
    }
}
