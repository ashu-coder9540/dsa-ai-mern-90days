
public class arrayImplementationOfStacks {

    public static class stack {
        private int[] arr = new int[5];
        private int idx = 0;
        int n = arr.length;
        int size = 0;

        void push(int val) {
            if (size == n) {
                System.out.println("Stack is Full");
                return;
            }
            arr[idx] = val;
            idx++;
            size++;
        }

        int peek() {
            if (idx > 0) {
                return arr[idx - 1];
            }
            return -1;
        }

        int pop() {
            if (idx == 0) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int val = arr[idx - 1];
            idx--;
            size--;
            return val;
        }

        int size() {
            return size;
        }

        int capacity() {
            return arr.length;
        }

        boolean isEmpty() {
            return size == 0;
        }

        boolean isFull() {
            return size == n;
        }

        void printStack() {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        stack st = new stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.printStack(); // 10 20 30
        System.out.println(st.peek()); // 30
        System.out.println(st.pop()); // 30
        System.out.println(st.size()); // 2
        System.out.println(st.capacity()); // 5
        System.out.println(st.isEmpty()); // false
        System.out.println(st.isFull()); // false 
    }
}
