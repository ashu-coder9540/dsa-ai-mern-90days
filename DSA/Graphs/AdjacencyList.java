import java.util.*;

public class AdjacencyList {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
        
    }
    public static void createGraph(ArrayList<Edge> graph[]){

        // In array currently at all indices there is a null value
        // we put empty array list in place of null
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        // Print 2's neighbours
        for(int i=0; i<graph[1].size(); i++){
            Edge e = graph[1].get(i);
            System.out.print(e.dest+" ");
        }

    }
}
