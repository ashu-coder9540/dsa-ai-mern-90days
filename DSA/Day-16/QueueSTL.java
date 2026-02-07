import java.util.*;

public class QueueSTL {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.offer(3);
        q.add(2);
        q.add(4);
        q.remove();
        q.poll();
        int val = q.peek();
        int x = q.element();
        boolean isEmpty = q.isEmpty();
        int size = q.size();
        System.out.println(val);
    }
}
