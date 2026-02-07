import java.util.*;

public class deque {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(10);
        dq.addLast(20);      
        dq.addFirst(5);
        dq.removeLast();
        dq.removeFirst();
        dq.peek();
        dq.isEmpty();
        System.out.println(dq); // [5, 10, 20]   
    }
}
