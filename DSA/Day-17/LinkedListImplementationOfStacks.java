
public class LinkedListImplementationOfStacks {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        Node top = null;
        int size = 0;


        void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            size++;
        }

        int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int poppedData = top.data;
            top = top.next;
            size--;
            return poppedData;
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return top.data;
        }

        boolean isEmpty() {
            return size == 0;
        }

        int size() {
            return size;
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println("Top element is: " + st.peek()); // 30
        System.out.println("st size is: " + st.size()); // 3
        System.out.println("Popped element is: " + st.pop()); // 30
        System.out.println("st size after pop is: " + st.size()); // 2
    }
}
