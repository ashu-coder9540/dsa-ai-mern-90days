class kthSmallestElement {

     public static int partition(int[] arr, int l, int r){
        int n = arr.length;
        // Choose the last element as pivot
        int pivot = arr[r];
        
        int start = l;
        
        for(int i=l; i<r; i++){
            if(arr[i]<=pivot){
                int temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
                start++;
            }
        }
        // Place the pivot in its correct position
        int temp = arr[start];
        arr[start] = arr[r];
        arr[r] = temp;
        return start;
    }
    public static int quickSelect(int[] arr, int l, int r, int k){
        if(l<=r){
            // Partition around pivot
            int pivotIdx = partition(arr,l,r);
            
            // Found kth smallest 
            if(pivotIdx == k) return arr[pivotIdx];
            else if(pivotIdx>k) {
            return quickSelect(arr, l, pivotIdx-1, k);
            }
            else{ // pivotIdx<k
            return quickSelect(arr,pivotIdx+1, r, k);
            }
        }
        // if kth element doesn't exist
        return -1;
    }
    public static int kthSmallest(int[] arr, int k) {
        // Partition function
        int n = arr.length;
        return quickSelect(arr, 0, n-1, k-1);
    }

    // method 2: using count sort when range of elements is small
     static int kthSmallest2(int[] arr, int k) {
 
        // First, find the maximum element in the array
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }

        // Create an array to store the frequency of each element
        int[] freq = new int[maxElement + 1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        // Keep track of the cumulative frequency of elements
        int count = 0;
        for (int i = 0; i <= maxElement; i++) {
            if (freq[i] != 0) {
                count += freq[i];
                if (count >= k) {
                    // If we have seen k or more elements,
                    // return the current element
                    return i;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 4, 6, 5};
        int k = 3;
        System.out.println("Kth smallest element is: " + kthSmallest(arr, k));
        System.out.println("Kth smallest element using method 2 is: " + kthSmallest2(arr, k));
    }
}