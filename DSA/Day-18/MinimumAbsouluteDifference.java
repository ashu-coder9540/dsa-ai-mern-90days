import java.util.*;


public class MinimumAbsouluteDifference {
     public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        // 1. sort the array using built in sort method
        Arrays.sort(arr);

        // 2. find min Diff 
        for(int i=1; i<n; i++){
            minDiff = Math.min(minDiff, arr[i] - arr[i-1]);
        }

        // 3. collect all pairs having min diff in res 
        for(int i=1; i<n; i++){
            if(arr[i]-arr[i-1] == minDiff)
                res.add(Arrays.asList(arr[i-1], arr[i]));
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        List<List<Integer>> result = minimumAbsDifference(arr);
        System.out.println(result); // Output: [[1, 2], [2, 3], [3, 4]]
    }
}
