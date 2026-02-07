
public class TransFormedArray {
    // Approach (Iterate and find)
    // T.C : O(n)
    // S.C : O(1)
    static int[] circularArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int shift = nums[i] % n; // keep shift within array bounds

            int newIdx = (i + shift) % n;

            // Java can still give negative modulo, so fix it
            if (newIdx < 0)
                newIdx += n;
            result[i] = nums[newIdx];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 3, -2, 1, 1 };
        int[] res = circularArray(arr);
        for (var e : res) {
            System.out.print(e + " ");
        }
    }
}
