
public class MergeOfPalindrome {
    static int findMinOpns(int[] arr, int n){
        int st = 0;
        int end = n-1;
        int count = 0;
        while(st < end){
            if(arr[st] == arr[end]){
                st++;
                end--;
            }
            else if(arr[st] < arr[end]){
                arr[st+1] += arr[st];
                st++;
                count++;
            }
            else{
                arr[end-1] += arr[end];
                end--;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {15, 4, 15};
        int n = arr.length;
        int result = findMinOpns(arr, n);
        System.out.println("Minimum number of operations required: " + result);
    }
}
