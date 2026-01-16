import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverLappingIntervals {
     public static ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Sort arr based on first element of inteval
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));
        ArrayList<int[]> res = new ArrayList<>();
        res.add(new int[] {arr[0][0], arr[0][1]});
        
        int n = arr.length;
        // Checking all possible overlaps
        for(int i=1; i<n; i++){
            int[] curr = arr[i];
            int[] last = res.get(res.size()-1);
            if(curr[0]<= last[1]){
                last[1] = Math.max(last[1], curr[1]);
            }else{
                res.add(new int[] {curr[0], curr[1]});
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,3}, {2,4}, {5,7}, {6,8}};
        ArrayList<int[]> res = mergeOverlap(arr);
        for(int[] interval: res){
            System.out.print(Arrays.toString(interval)+ " ");
        }
    }
}
