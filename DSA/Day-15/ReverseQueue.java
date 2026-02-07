import java.util.*;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> q) {
       Stack<Integer> st = new Stack<>();
        
       while(q.size() > 0){
           st.push(q.remove());
       }

       while(st.size() > 0){
            q.add(st.pop());
       }
    }
    public static Queue<Integer> reverseFirstKthQueue(Queue<Integer> q, int k){

        if(q == null || k <= 0 || k > q.size()) return q;

        Stack<Integer> st = new Stack<>();
        
        // s1: add first k element into stack
        for(int i=0; i<k; i++){
            st.push(q.remove());
        }
        
        // s2: move back element in queue
        while(st.size()>0){
            q.add(st.pop());
        }
        
        // s3: add first n-k element to the last of q
        for(int i=0; i<q.size()-k; i++){
            q.add(q.remove());
        }
        return q;
    }
    public static void main(String[] args) {
        // Create a queue and add some elements
        Queue<Integer> q = new LinkedList<>();      
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println("Original Queue: " + q);

        // Reverse the queue
        reverseQueue(q );

        System.out.println("Reversed Queue: " + q);

        int k = 3;
        // Reverse first kth element of q
        reverseFirstKthQueue(q, k);

        System.out.println("Reversed first" + k + "elements of q = " + q);
    }
}
