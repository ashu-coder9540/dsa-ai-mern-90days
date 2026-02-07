import java.util.*;

public class MyStack {
     Queue<Integer> q = new LinkedList<>();
    public MyStack() {
    }
    // push efficient
   /*  
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        for(int i=1; i<=q.size()-1; i++){
            q.add(q.remove());
        }
        int x = q.remove();
        return x;
    }
    
    public int top() {
        for(int i=1; i<=q.size()-1; i++){
            q.add(q.remove());
        }
        int val = q.peek();
        q.add(q.remove());
        return val;
    }
    
    public boolean empty() {
        if(q.size()==0) return true;
        else return false;
    } */

        // pop efficient
      public void push(int x) {
        if(q.size()==0) q.add(x);
        else{
            q.add(x);
            for(int i=1; i<=q.size()-1; i++){
                q.add(q.remove());
            }
        }  
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        if(q.size()==0) return true;
        else return false;
    }
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.top());   // 30
        System.out.println(stack.pop());   // 30
        System.out.println(stack.top());   // 20
        System.out.println(stack.empty()); // false
    }
}
