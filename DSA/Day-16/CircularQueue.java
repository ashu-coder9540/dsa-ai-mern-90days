public class CircularQueue {
    public static class Cqa{
        int f = -1;
        int r = -1;
        int size = 0;
        int[] arr = new int[8];
        int n = arr.length;
        // add()
        public void add(int val) throws Exception{
            if(size==0){
                f = r = 0;
                arr[0] = val;
                size++;
                return;
            }
            if(size==n){
                throw new Exception("Queue is Full");
            }
            else if(r==n-1){
                r=0;
                arr[r] = val;
            }else{
                arr[++r] = val;
            }
            size++;
        }
        public int remove() throws Exception{
            if(size==0){
                throw new Exception("Queue is Empty");
            }
            else {
                int x = arr[f];
                if(f==n-1){
                    f=0;
                }else{
                    f++;
                }
                size--;
                return x;
            }
        }
        public int peek() throws Exception{
            if(size==0){
                throw new Exception("Queue is Empty");
            }
            return arr[f];
        }
        public void display(){
            if(size==0){
                System.out.println("Queue is Empty");   
                return;
            }
            if(f<=r){
                for(int i=f; i<=r; i++){
                    System.out.print(arr[i] + " ");
                }
            }else{  // rear < front 
             for(int i=f; i<=n-1; i++){
                    System.out.print(arr[i] + " ");
                }
            for(int i=0; i<=r; i++){
                System.out.print(arr[i] + " ");
            }
        }        
            System.out.println();   
        }
        public boolean isEmpty(){
            return size==0;
        }
    }
    public static void main(String[] args) throws Exception {
        Cqa q = new Cqa();
        q.display(); // Queue is Empty
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.display();  // 10 20 30 40
        System.out.println(q.peek()); // 10
        System.out.println(q.remove()); // 10
        q.display(); // 20 30 40
        System.out.println(q.peek());  // 20
        System.out.println(q.isEmpty()); // false
        q.add(50);
        q.add(60);  
        q.add(70);
        q.add(80);  
        q.display(); // 20 30 40 50 60 70 80
        q.add(90); // 20 30 40 50 60 70 80 90
        q.display();
        q.add(100); // Exception: Queue is Full
        
    }
}
