public class sqrtDecomposition {

    public static int query(int[] blocks, int[] arr, int l, int r, int sqrt) {
        int ans = 0;

        // Left part
        while (l <= r && l % sqrt != 0) {
            ans += arr[l];
            l++;
        }

        // Middle part (full blocks)
        while (l + sqrt - 1 <= r) {
            ans += blocks[l / sqrt];
            l += sqrt;
        }

        // Right part
        while (l <= r) {
            ans += arr[l];
            l++;
        }

        return ans;
    }

    public static void update(int[] blocks, int[] arr, int idx, int value, int sqrt) {
        int block_id = idx / sqrt;
        blocks[block_id] += value - arr[idx];
        arr[idx] = value;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;

        int sqrt = (int) Math.sqrt(n) + 1;
        int[] blocks = new int[sqrt];

        // Build blocks
        for (int i = 0; i < n; i++) {
            blocks[i / sqrt] += arr[i];
        }

        // Query sum from index 3 to 8
        System.out.println(query(blocks, arr, 3, 8, sqrt));  // Output: 23
    }
}
