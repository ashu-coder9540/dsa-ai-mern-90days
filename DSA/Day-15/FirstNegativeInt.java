import java.util.*;

public class FirstNegativeInt {
    static List<Integer> firstNegInt(int arr[], int k) {
        // BruteForce Approach
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n - k + 1; i++) {
            boolean found = false;
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    ans.add(arr[j]);
                    found = true;
                    break;
                }
            }
            if (!found)
                ans.add(0);
        }
        return ans;
    }

    // Optimal Approach Using Queue
    static List<Integer> firstNegIntOptimized(int arr[], int k) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int n = arr.length;

        // Adding -ve value indices in queue
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                q.add(i);
        }

        for (int i = 0; i <= n - k; i++) {
            while (!q.isEmpty() && q.peek() < i) {
                q.poll();
            }

            if (!q.isEmpty() && q.peek() <= i + k - 1) {
                res.add(arr[q.peek()]);
            } else
                res.add(0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { -8, 2, 3, -6, 10 };
        int k = 2;
        List<Integer> res = firstNegInt(arr, k);
        System.out.println(res);

        List<Integer> res2 = firstNegIntOptimized(arr, k);
        System.out.println(res2);
    }
}