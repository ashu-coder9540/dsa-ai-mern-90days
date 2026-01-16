
public class PalindromicArray {
     public static boolean helper(int a){
        String s = Integer.toString(a);
        int st = 0;
        int end = s.length()-1;
        // Use 2 pointer technique
        while(st<end){
            if(s.charAt(st) != s.charAt(end)){
                return false;
            }
            st++;
            end--;
            }
            return true;
        }
    public static boolean isPalinArray(int[] arr) {
        int n = arr.length;
        // add code here.
        for (int i=0; i<n; i++){
        if(!helper(arr[i])){
           return false;
        }
    }
        return true;
   }
    public static void main(String[] args) {
        int[] arr = {121, 131, 20};
        System.out.println(isPalinArray(arr));
    }
}
