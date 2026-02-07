public class LinkedListImplementation {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }

    public static class queueLL{
        Node head = null;
        Node tail = null;
        int size = 0;
        public void add(int x){
            Node temp = new Node(x);
            if(size==0){
                head = tail = temp;
            }
            else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public int peek(){
            if(size==0){
                System.out.println("Queue is Empty!");
                return -1;
            }
            return head.val;
        }

        public int remove(){
             if(size==0){
                System.out.println("Queue is Empty!");
                return -1;
            }
            int x = head.val;
            head = head.next;
            size--;
            return x;   
        }
        public void display(){
            if(size==0){
                System.out.println("Queue is Empty!");
                return;
            }
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp = temp.next;
            }
            System.out.println();
        }
        public boolean isEmpty(){
            return size==0;
        }
    }
    }
    public static void main(String[] args) {
        LinkedListImplementation.Node.queueLL q = new LinkedListImplementation.Node.queueLL();
        q.add(10);
        q.add(20);
        q.add(30);
        q.display(); // Output: 10 20 30
        System.out.println(q.peek()); // Output: 10
        System.out.println(q.remove()); // Output: 10
        q.display(); // Output: 20 30
        System.out.println(q.isEmpty()); // Output: false
    }
}
