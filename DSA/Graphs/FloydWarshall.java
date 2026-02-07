public class FloydWarshall {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        int INF = (int)1e8;

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {

                    // If either path is unreachable, skip
                    if(dist[i][k] == INF || dist[k][j] == INF) continue;

                    // Relaxation step
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    public void shortest_distance(int[][] dist){
        int n = dist.length;
        int INF = (int)1e9;

        // Step 1: Replace -1 with INF and set diagonal 0
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dist[i][j] == -1) dist[i][j] = INF;
                if(i == j) dist[i][j] = 0;
            }
        }

        // Step 2: Floyd Warshall Algorithm
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Step 3: Negative cycle detection (optional, for understanding)
        for(int i = 0; i < n; i++){
            if(dist[i][i] < 0){
                System.out.println("Negative cycle detected");
            }
        }

        // Step 4: Convert INF back to -1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dist[i][j] == INF) dist[i][j] = -1;
            }
        }
    }
    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int[][] graph = {
            {0, 3, -1, 7},
            {8, 0, 2, -1},
            {5, -1, 0, 1},
            {2, -1, -1, 0}
        };

        fw.shortest_distance(graph);

        // Print the shortest distance matrix
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        } 

        fw.floydWarshall(graph);
        System.out.println();
        // Print the shortest distance matrix after Floyd-Warshall
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
