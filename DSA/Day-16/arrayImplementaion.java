public class arrayImplementaion {
    public static class queueA{
        int f = -1;
        int r = -1;
        int size=0;
        int[] arr = new int[100];

        public void add(int val){
            if(r==arr.length-1) {
                System.out.println("Queue is full");
                return;
            }
            if(f==-1) {
                f = r =0;
                arr[r]=val;
            } else{
                arr[++r]=val;
            }
            size++;
        }
        public int remove(){
            if(size==0){
                System.out.println("Queue is empty");
                return -1;
            }
            int val = arr[f];
            f++;
            if(size==0){
                f=r=-1;
            }
            size--;
            return val;
        }
        public int peek(){
            if(size==0){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[f];
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return size==0;
        }
        public void display(){
            if(size==0){
                System.out.println("Queue is empty");
                return;
            }
            for(int i=f;i<=r;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
    }
}
    public static void main(String[] args) {
        queueA q = new queueA();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.display();
        System.out.println(q.remove());
        q.display();
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
    }
}
