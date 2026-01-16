import java.util.ArrayList;
import java.util.Collections;

class ChocolateDistribution {
    public static int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        int n = arr.size()-1;
        // sort given pkts
        Collections.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        // Iterate the window till the end of the array
        for(int i=0; i+m-1<=n; i++){
            int diff = arr.get(i+m-1)-arr.get(i);
            if(diff<minDiff){
                minDiff = diff;
            }
        }
        return minDiff;
    }
   public static void main(String[] args) {
         ArrayList<Integer> arr = new ArrayList<>();
         arr.add(7);
         arr.add(3);
         arr.add(2);
         arr.add(4);
         arr.add(9);
         arr.add(12);
         arr.add(56);
         int m = 3;
         int result = findMinDiff(arr, m);
         System.out.println("Minimum difference is: " + result);
   }
}