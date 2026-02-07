import java.util.Stack;

public class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public MyQueue() {
    }

    // push efficient
    /*
     * public void push(int x) {
     * st.push(x);
     * }
     * 
     * public int pop() {
     * while(st.size()>1){
     * helper.push(st.pop());
     * }
     * int val = st.pop();
     * while(helper.size()>0){
     * st.push(helper.pop());
     * }
     * return val;
     * }
     * 
     * public int peek() {
     * while(st.size()>1){
     * helper.push(st.pop());
     * }
     * int val = st.peek();
     * while(helper.size()>0){
     * st.push(helper.pop());
     * }
     * return val;
     * }
     * 
     * public boolean empty() {
     * if(st.size()==0) return true;
     * else return false;
     * }
     */
    // pop efficient
    public void push(int x) {
        if (st.size() == 0)
            st.push(x);
        else {
            while (st.size() > 0) {
                helper.push(st.pop());
            }
            st.push(x);
            while (helper.size() > 0) {
                st.push(helper.pop());
            }
        }
    }

    public int pop() {
        return st.pop();
    }

    public int peek() {
        return st.peek();
    }

    public boolean empty() {
        if (st.size() == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        MyQueue Queue = new MyQueue();

        Queue.push(10);
        Queue.push(20);
        Queue.push(30);

        System.out.println(Queue.peek()); // 10
        System.out.println(Queue.pop()); // 10
        System.out.println(Queue.peek()); // 20
        System.out.println(Queue.empty()); // false
    }
}
