import java.util.ArrayList;
import java.util.Collections;

public class SubsetsSum {
    public static ArrayList<Integer> helper(int idx, int[] arr, int n, int sum){
        ArrayList<Integer> res = new ArrayList<>();
        // Base case
        if(idx == n){
            res.add(sum);
            return res;
        }
        // Include curr element
        ArrayList<Integer> left = helper(idx+1, arr, n, sum + arr[idx]);
        
        // Exclude the curr element
        ArrayList<Integer> right = helper(idx+1, arr, n, sum);
        
        // Merge both results
        res.addAll(left);
        res.addAll(right);

        Collections.sort(res);
        
        return res;
    }
     public static ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        return helper(0, arr, arr.length, 0);
    }

    public static void main(String[] args) {
        int[] arr = {5,2,1};
        ArrayList<Integer> res = subsetSums(arr);
        System.out.println(res);
    }
}
