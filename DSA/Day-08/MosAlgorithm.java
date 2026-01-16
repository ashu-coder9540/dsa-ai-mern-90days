import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MosAlgorithm {
    class Query {
        int l, r;

        Query(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    // Basic Approach to process queries
    static void printQuerySums(int a[], int n, ArrayList<Query> q, int m){
        // One by one compute sum of all queries
        for(int i=0; i<m; i++){ //Time Complexity: O(n*m), space: O(1)
            // left and right boundaries of current query
            int L = q.get(i).l;
            int R = q.get(i).r;

            // Compute sum from L to R
            int sum = 0;
            for(int j=L; j<=R; j++)
                sum += a[j];

            // print sum of current query Range
            System.out.println("Sum of [" + L + ", " + R + "] is " + sum);
        }
    }

    // Advanced Approach using Mo's Algorithm would go here
    static void printQuerySumsMo(int a[], int n, ArrayList<Query> q, int m){
        // Find block size
        int block = (int)Math.sqrt(n);

        // Sort all queries so that queries of same block are arranged together
        Collections.sort(q, new Comparator<Query>() {
            // function used to sort all queries so that all queries 
            // of same block are arranged together.
            // Queries are sorted in increasing order of R values
            public int compare(Query x, Query y) {
                int blockX = x.l / block;
                int blockY = y.l / block;
                // Different blocks, sort by block number
                if (blockX != blockY)
                    return blockX - blockY;
                // Same block, sort by R value
                return x.r - y.r;
            }
        });

        // Initialize current L, current R and current sum
        int currL = 0, currR = 0;   
        int currSum = 0;

        // Traverse through all queries
        for (int i = 0; i < m; i++) {
            int L = q.get(i).l;
            int R = q.get(i).r;

            // Remove extra elements of previous range
            while (currL < L) {
                currSum -= a[currL];
                currL++;
            }
            // Add new elements of current range
            while (currL > L) {
                currSum += a[currL - 1];
                currL--;
            }
            // add new elements of current range
            while (currR <= R) {
                currSum += a[currR];
                currR++;
            }
            // Remove extra elements of previous range
            while (currR > R + 1) {
                currSum -= a[currR - 1];
                currR--;
            }

            // Print sum of current query range
            System.out.println("Sum of [" + L + ", " + R + "] is " + currSum);
        }
    }
    public static void main(String[] args) {
        // Placeholder for Mos Algorithm implementation
        int a[] = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        int n = a.length;

        ArrayList<Query> q = new ArrayList<>();
        q.add(new MosAlgorithm().new Query(0, 4));
        q.add(new MosAlgorithm().new Query(1, 3)); 
        q.add(new MosAlgorithm().new Query(2, 4));

        int m = q.size();
        printQuerySumsMo(a, n, q, m);
    }
}
