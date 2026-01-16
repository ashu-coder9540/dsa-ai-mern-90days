import java.util.*;
public class PairSumInSandR {
     static boolean pairInSortedRotated(int arr[], int target) {
        // # Use hashing
        HashSet<Integer> set = new HashSet<>();
        // iterate on every el
        // and check compl is avail in set or not
        int i = 0;
        int n = arr.length;;
        for(i=0; i<n; i++){
            int comp = target - arr[i];
            
            if(set.contains(comp)){
                return true;
            }
            
            set.add(arr[i]);
        }
        // If no pair is found
        return false;
    }
    static boolean pairInSortedRotated2(int arr[], int target) {
        // # Use two pointer approach
        int n = arr.length;
        int i;
        // find pivot
        for(i=0; i<n-1; i++){
            if(arr[i] > arr[i+1]){
                break;
            }
        }
        int l = (i+1)%n; // smallest el
        int r = i; // largest el
        
        // two pointer approach
        while(l != r){
            if(arr[l] + arr[r] == target){
                return true;
            }
            if(arr[l] + arr[r] < target){
                l = (l+1)%n;
            } else {
                r = (n + r - 1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {11, 15, 6, 8, 9, 10};
        int target = 16;
        System.out.println(pairInSortedRotated(arr, target));
    }
}
