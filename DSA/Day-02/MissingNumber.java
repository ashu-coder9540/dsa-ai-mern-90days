
public class MissingNumber {
      int missingNum(int arr[]) {
        //#1: Basic Approach: Linear search
        int n = arr.length + 1;
        for(int i=1; i<=n; i++){
            boolean found = false;
            for(int j=0; j<arr.length; j++){
                if(arr[j]==i){
                    found = true;
                    break;
                }
            }
            if(!found){
                return i;
            }
        }
        return -1;
    }
        int missingNumberOptimized(int arr[]) {
      //#2: Optimized Approach: using hashing( key-value pair)
        int n = arr.length + 1;
        int[] hash = new int[n+1];
        
        // Fill hash Key value pair
        for(int i=0; i<n-1; i++){
            hash[arr[i]]++;
        }
        
        // Find Missing No.
        for(int i=1; i<=n; i++){
            if(hash[i]==0){
                return i;
            }
        }
        return -1;
    }
        int missingNumberSpaceOptimized(int arr[]) {
         //#3: Space optimized: using sum of nth term formula
        long n = arr.length+1;
        // calculate sum of arr el
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        // Calculate expSum 
        long expSum = n*(n+1)/2;
        return (int)(expSum - sum);
    }
        int missingNumberXOR(int arr[]) {
         //#4: Using XOR: T.C = O(n), S.C = O(1)
        int n = arr.length + 1;
        int xor1 = 0, xor2 = 0;
        
        // XOR all array elements
        for(int i=0; i<arr.length; i++){
            xor2^=arr[i];
        }
        
        // XOR el from 1 to n
        for(int i=1; i<=n; i++){
            xor1^=i;
        }
        // Missing number is the XOR of xor1 and xor2
        return xor1 ^ xor2;
    }
    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        int arr[] = {1, 2, 4, 6, 3, 7, 8};
        System.out.println("Missing Number (Basic Approach): " + obj.missingNum(arr));
        System.out.println("Missing Number (Optimized Approach): " + obj.missingNumberOptimized(arr));
        System.out.println("Missing Number (Space Optimized): " + obj.missingNumberSpaceOptimized(arr));
        System.out.println("Missing Number (XOR Approach): " + obj.missingNumberXOR(arr));
    }
}
