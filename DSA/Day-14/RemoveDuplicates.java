import java.util.*;

public class RemoveDuplicates {
      public static int removeDuplicates(int[] nums) {
        // By Using HashSet-> BruteForce
        int n = nums.length;
        HashSet<Integer> st = new HashSet<>();
        // create unique element in set
        for(int i=0; i<n; i++){
            st.add(nums[i]);
        }
        // traverse on set and build unique element array in place using idx variable 
        // and return (idx) idx which is telling unique element in given array
        int idx = 0;
        for(int it: st){
            nums[idx] = it;
            idx++;
        }
        return (idx);
    }
    public static int removeDuplicatesOptimal(int[] nums) {
        // Optimal Approach using two pointer in single pass TC = O(n), SC = O(1)
        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[j]!=nums[i]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        return (i + 1);
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,4,5};
        int k = removeDuplicates(nums);
        System.out.println("The length of array after removing duplicates is: " + k);
        System.out.print("The array after removing duplicates is: ");
        for(int i=0; i<k; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
