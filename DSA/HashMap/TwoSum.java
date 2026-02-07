import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        int n = nums.length;
        int[] ans = {-1};
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[j] == target - nums[i]){
                    ans = new int[]{i, j};
                    return ans;
                }
            }
        }
        return ans;
    }

    public static int[] twoSumOptimized(int[] nums, int target){
        int n = nums.length;
        int[] ans = new int[] {-1};
        // Value, Index
       HashMap<Integer, Integer> mp = new HashMap<>();
       for(int i=0; i<n; i++){
        int partner = target - nums[i];
        if(mp.containsKey(partner)){
            ans = new int[]{i, mp.get(partner)};
            return ans;
        }
        mp.put(nums[i], i); 
       }
       return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSumOptimized(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
