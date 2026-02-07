import java.util.ArrayList;

public class findDist {
    static class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
    }

}
    
    /* int findDist(Node root, int a, int b) {
        Node LCA = lca(root, a, b);
        int[] dist = {0, 0};
        dfs(LCA, a, b, 0, dist);
        return dist[0] + dist[1];
    }
    
    private void dfs(Node root, int a, int b, int level, int[] dist){
        if(root==null) return;
        if(root.data == a) dist[0] = level;
        if(root.data == b) dist[1] = level;
        dfs(root.left, a, b, level+1, dist);
        dfs(root.right, a, b, level+1, dist);
    }
    
    Node lca(Node root, int p, int q) { //TC = O(n)
    if(root == null) return null;
        if(root == null) return null;
        if(root.data==p || root.data==q) return root;
        Node l = lca(root.left, p, q);
        Node r = lca(root.right, p, q);
        if(l!=null && r!=null){
            return root;
        }
      
        return (l==null) ? r : l;
    } */

     // Find path from root to target
        boolean findPath(Node root, int target, ArrayList<Node> path) {
        if (root == null) return false;

        // Add current node
        path.add(root);

        // If found
        if (root.data == target)
            return true;

        // Search left & right
        if (findPath(root.left, target, path) ||
            findPath(root.right, target, path))
            return true;

        // Backtrack
        path.remove(path.size() - 1);
        return false;
    }

    // Using 2 ArrayList 
        int findDistOptimized(Node root, int a, int b) {

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // Find paths
        if (!findPath(root, a, path1) ||
            !findPath(root, b, path2)) {
            return -1; // Node not found
        }

        int i = 0;

        // Find LCA index
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) != path2.get(i))
                break;
            i++;
        }

        // Distance formula
        return (path1.size() - i) + (path2.size() - i);
    }

    public static void main(String[] args) {
        findDist tree = new findDist();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int a = 4, b = 5;
        System.out.println("Distance between " + a + " and " + b + " is: " + tree.findDistOptimized(root, a, b)); // Output: 2
    }
}
