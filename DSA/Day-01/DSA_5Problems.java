// q1: Reverse an array Using two pointer approach 

import java.util.*;

class Main {
    // q1: Reverse an array Using two pointer approach
    public static void reverse(int[] arr) {
        int n = arr.length;
        // int i=0, j=n-1;
        // while(i<j){
        //     int temp = arr[i];
        //     arr[i] = arr[j];
        //     arr[j] = temp;
        //      i++;
        //      j--;
        // }
         // using half loop approach
        for(int i=0; i<n/2; i++){
            int temp = arr[i];
             arr[i] = arr[n-i-1];
             arr[n-i-1] = temp;
        }
    }
//   q2: Find the maximum and minimum element in an array
     public static ArrayList<Integer> getMinMax(int[] arr) {
        // #1: Sorting array
        // create empty array list
        ArrayList<Integer> sortedArr = new ArrayList<>();
        // add all el in arrayList
        for(int e: arr){
            sortedArr.add(e);
        }
        // sort ArrayList
        Collections.sort(sortedArr);
        
        // create new res ArrayList of integer
        ArrayList<Integer> res = new ArrayList<>();
        res.add(sortedArr.get(0));
        res.add(sortedArr.get(sortedArr.size()-1));
        
        return res;
        
        // #2: by iterating array
        // int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;
        // int n = arr.length;
        // ArrayList<Integer> res = new ArrayList<>();
        // // traverse the array
        // for(int i= 0; i<n; i++){
        //     if(arr[i]>max){
        //         max = arr[i];
        //     }
        //      if(arr[i]<min){
        //         min = arr[i];
        //     }
        // }
        // // add min and max in res arrayList
        // res.add(min);
        // res.add(max);
        // return res;
    }
    // #3: Using Divide and Conquer approach
     public static ArrayList<Integer> getMinMax3(int[] arr, int low, int high) {
        // Base case: if there are two elements
        if (high == low + 1) {
            ArrayList<Integer> res = new ArrayList<>();
            if (arr[low] > arr[high]) {
                res.add(arr[high]);
                res.add(arr[low]);
            } else {
                res.add(arr[low]);
                res.add(arr[high]);
            }
            return res;
        }

        // Divide the array into two halves
        int mid = (low + high) / 2;
        ArrayList<Integer> leftMinMax = getMinMax3(arr, low, mid);
        ArrayList<Integer> rightMinMax = getMinMax3(arr, mid + 1, high);

        // Combine the results from both halves
        ArrayList<Integer> result = new ArrayList<>();
        result.add(Math.min(leftMinMax.get(0), rightMinMax.get(0)));
        result.add(Math.max(leftMinMax.get(1), rightMinMax.get(1)));
        return result;
    }
    // q3: Check if a no. is palindrome or not

    // basic approach: by rev number
    public static boolean isPalindrome(int n) {
        int rev = 0;
        int temp = Math.abs(n);
        while (temp != 0) {
            int digit = temp % 10;
            rev = rev * 10 + digit;
            temp /= 10;
        }
        return (rev == Math.abs(n));
    }

    // using number as string
    public static boolean isPalindromeString(int n) {
        String numStr = Integer.toString(n);
        int left = 0;
        int right = numStr.length() - 1;

        while (left < right) {
            if (numStr.charAt(left) != numStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // q4: Move all zeros to end of array

    // //#1: basic approach: using extra array
    // public static void moveZerosToEnd(int[] arr) {
    //     int n = arr.length;
    //     int[] temp = new int[n];
    //     int j = 0;

    //     // Copy non-zero elements to the result array
    //     for (int i = 0; i < n; i++) {
    //         if (arr[i] != 0) {
    //             temp[j++] = arr[i];
    //         }
    //     }

    //     // Fill the remaining positions with zeros
    //     while (j < n) {
    //         temp[j++] = 0;
    //     }

    //     // Copy the result back to the original array
    //     for (int i = 0; i < n; i++) {
    //         arr[i] = temp[i];
    //     }
    // }

    // // #2:Two traversal in-place approach
    // public static void moveZerosToEndInPlace(int[] arr) {
    //    int count = 0;
    //    int n = arr.length;

    //    for(int i=0; i<n; i++){
    //     if(arr[i]!=0){
    //         arr[count++] = arr[i];
    //     }
    //    }
    //      while(count<n){
    //       arr[count++] = 0;
    //      }
    // }

    // #3: Single traversal in-place approach
    public static void moveZerosToEndSingleTraversal(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                // Swap the current element with the last non-zero element
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
        System.out.println("Array after moving zeros to end:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    //q5: find second largest element in an array
      // #1: Basic approach: sort the array
    // public static int findSecondLargest(int[] arr) {
      
    //     int n = arr.length;
    //     Arrays.sort(arr);
    //     for(int i=n-2; i>=0; i--){
    //         if(arr[i]!=arr[n-1]){
    //             return arr[i];
    //         }
    //     }
    //     return -1; // if no second largest element exists
    // }
    // // #2: Optimal approach: Two pass approach
    // public static int findSecondLargestOptimal(int[] arr) {
    //     int n = arr.length;
    //     int max = Integer.MIN_VALUE;
    //     for(int i=0; i<n; i++){
    //         if(arr[i]>max){
    //             max = arr[i];
    //         }
    //     }
    //     int secondMax = Integer.MIN_VALUE;
    //     for(int i=0; i<n; i++){
    //         if(arr[i]>secondMax && arr[i]<max){
    //             secondMax = arr[i];
    //         }
    //     }
    //     return secondMax;
    // }
    // #3: Single pass approach
    public static int findSecondLargestSinglePass(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // Call the reverse function
        reverse(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Call the getMinMax function
       System.out.println(getMinMax(array));

         // Call the isPalindrome function
        int number = 1234;
        System.out.println(isPalindrome(number));

        // Call the moveZerosToEndSingleTraversal function
        int[] arrayWithZeros = {0, 1, 0, 3, 12};
        moveZerosToEndSingleTraversal(arrayWithZeros);

        // Call the findSecondLargestSinglePass function
        int[] arrayForSecondLargest = {12, 35, 1, 10, 34, 1};
        System.out.println(findSecondLargestSinglePass(arrayForSecondLargest));
    }
}