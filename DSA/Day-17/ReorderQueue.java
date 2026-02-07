import java.util.*;
public class ReorderQueue {
    public static void reorderQueue(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        int size = q.size();
        int halfSize = size / 2;

        // Step 1: Push the first half of the queue onto the stack
        for (int i = 0; i < halfSize; i++) {
            st.push(q.remove());
        }    // 5 6 7 8            top 4 3 2 1

        // Step 2 : Empty Stack to the queue last 
        while(st.size()>0){
            q.add(st.pop());
        } // 5 6 7 8 4 3 2 1

        //Step 3 : Move 1st (2nd) half to the stack
        for(int i=0; i< halfSize; i++){
            st.push(q.remove());
        } // 4 3 2 1             top 8 7 6 5

        // Step 4 : One by One add st.peek & q.peek to q
        for(int i=0; i<halfSize; i++){
            q.add(st.pop());
            q.add(q.remove());
        } // 8 4 7 3 6 2 5 1

        // Step 5 : Reverse q using stack
        while(!q.isEmpty()){
            st.push(q.remove());
        } 
        while(!st.isEmpty()){
            q.add(st.pop());
        } // 1 5 2 6 3 7 4 8
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);  
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);  
        System.out.println("Original Queue: " + q); // [1, 2, 3, 4, 5, 6, 7, 8]
        reorderQueue(q);
        System.out.println("Reordered Queue: " + q); // [1, 8, 2, 7, 3, 6, 4, 5]
    }
}
