import java.util.ArrayList;

public class FlattenBinaryTree {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
          this.data = data;
        }
    }

    // Method 1: Using ArrayList to store nodes in preorder
    public static void flatten(Node root) {
        ArrayList<Node> arr = new ArrayList<>();
        dfs(root, arr);
        for(int i=0; i<arr.size()-1; i++){
            Node a = arr.get(i);
            Node b = arr.get(i+1);
            a.right = b;
            a.left = null;
        }
        
        Node last = arr.get(arr.size()-1);
        last.left = null;
        last.right = null;
    }
    public static void dfs(Node root, ArrayList<Node> arr){
        if(root==null) return;
        arr.add(root);
        dfs(root.left, arr);
        dfs(root.right, arr);
    }

    public static void flatten1(Node root){
        if(root==null) return;
        Node lst = root.left;
        Node rst = root.right;
        root.left = null;
        root.right = null;
        // currently we have 3 parts of tree 
        // root, lst, rst
        flatten1(lst);
        flatten1(rst);
        root.right = lst;
        Node last = root; // this is the last element of lst
        while(last.right!=null) last = last.right;
        last.right = rst;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        flatten1(root);

        // Print flattened tree
        Node curr = root;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }
}
