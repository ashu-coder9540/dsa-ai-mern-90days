import java.util.*;

public class displayQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        Queue<Integer> helper = new LinkedList<>();
        // Display Queue in ascending order
       /*  while(q.size()>0){
            System.out.print(q.peek() + " ");
            helper.add(q.remove());
        }
        while (helper.size()>0) {
            q.add(helper.remove());
        } */

        // Display Queue in reverse order
         // Size of queue
    int s = q.size();

    // Second queue
    Queue<Integer> ans = new LinkedList<>();

    for (int i = 0; i < s; i++)
    {

        // Get the last element to the
        // front of queue
        for (int j = 0; j < q.size() - 1; j++) 
        {
            int x = q.peek();
            q.remove();
            q.add(x);
        }

        // Get the last element and
        // add it to the new queue
        ans.add(q.peek());
        q.remove();
    }
    System.out.println(ans);
    }
}
