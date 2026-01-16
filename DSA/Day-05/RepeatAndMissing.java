import java.util.ArrayList;
import java.util.HashMap;

public class RepeatAndMissing {
    // Approach 2: Using HashMap
     /* static ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>(); //s.c = n
        ArrayList<Integer> list = new ArrayList<>();
        // Step 1: Count frequency
        for(int num: arr){ // t.c = n
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int missing = -1;
        int repeating = -1;
        
        // Step 2: Check number from 1 to n
        for(int i=1; i<=n; i++){ // t.c = n
            if(!map.containsKey(i)){
                missing = i;
            }else if(map.get(i)==2){
                repeating = i;
            }
        }
        list.add(repeating);
        list.add(missing);
        
        return list;
    } */
    // Approach 3: Optimal Approach (Using Math)
    static ArrayList<Integer> findTwoElementOptimal(int arr[]) {
        // code here
        int n = arr.length;
        long sumN = (long)n*(n+1)/2; // Sum of first n natural numbers
        long sumNSq = (long)n*(n+1)*(2*n+1)/6; // Sum of squares of first n natural numbers
        
        long sumArr = 0;
        long sumArrSq = 0;
        
        for(int num: arr){
            sumArr += num;
            sumArrSq += (long)num * (long)num;
        }
        
        long diff = sumN - sumArr; // missing - repeating
        long diffSq = sumNSq - sumArrSq; // missing^2 - repeating^2
        
        // missing + repeating = diffSq / diff
        long sumMR = diffSq / diff;
        
        long missing = (diff + sumMR) / 2;
        long repeating = missing - diff;
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add((int)repeating);
        list.add((int)missing);
        
        return list;
    }
    // Approach 4: Using Xor
    static ArrayList<Integer> findTwoElementXor(int arr[]) {
        int xor =0;
        int n = arr.length;
        // step 1:XOR array elements and numbers from 1 to n
        for(int i=-0; i<n; i++){
            xor ^= arr[i];
            xor ^= (i+1);
        }
        // Now xor = repeating ^ missing
        // step 2: find rightmost set bit
        // int setBit = xor & ~(xor -1);
        int bitNo = 0;
        while(true){
            if((xor & (1 << bitNo)) !=0){
                break;
            }
            bitNo++;
        }

        // Divide elements into 2 sets and perform xor
        int zero=0; // missing or repeating
        int one=0; // missing or repeating

        for(int i=0; i<n; i++){
            // In arr: part of 1 club
            if((arr[i] & (1 << bitNo)) !=0){
                one ^= arr[i];
            // part of 0 club
            }else{
                zero ^= arr[i];
            }
            // In n number: part of 1 club
            if(((i+1) & (1 << bitNo)) !=0){
                one ^= (i+1);
            // part of 0 club
            }else{
                zero ^= (i+1);
            }
        }
        // Now one and zero are either missing or repeating
        int cnt = 0;
        for(int num: arr){
            if(num == one){
                cnt++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if(cnt == 2){
            list.add(one); // repeating
            list.add(zero); // missing
        }else{
            list.add(zero); // repeating
            list.add(one); // missing
        }
        return list;
    }
    public static void main(String[] args) {
        int arr[] = {3, 1, 3};
        ArrayList<Integer> result = findTwoElementXor(arr);
        System.out.println("Repeating Number: " + result.get(0));
        System.out.println("Missing Number: " + result.get(1));
    }
}
