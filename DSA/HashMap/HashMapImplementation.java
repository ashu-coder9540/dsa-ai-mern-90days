import java.util.LinkedList;

public class HashMapImplementation {
    static class MyHashMap<K, V>{
        public static final int DEFAULT_CAPACITY = 4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;
        private class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; //return the entries in the map
        private LinkedList<Node>[] buckets;


        private void initBuckets(int N){ //N - capacity/size of buckets array
            buckets = new LinkedList[N];
            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        private int HashFunc(K key){
            int hc = key.hashCode();
            return (Math.abs(hc)) % buckets.length;
        }
        // Traverses the ll and loos for a node with key, if found it returns it's idx otherwise returns null
        private int searchInBucket(LinkedList<Node> ll, K key){
            for(int i=0; i<ll.size(); i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }
            return -1; //key doesn't exist
        }

        public int capacity(){
            return buckets.length;
        }

        public float load(){
            return (n*1.0f)/buckets.length;
        }

        private void rehash(){
            LinkedList<Node>[] oldBuckets = buckets;
            n=0;
            initBuckets(oldBuckets.length*2);
            for(var bucket: oldBuckets){
                for(var node: bucket){
                    put(node.key, node.value);
                }
            }
        }

        public MyHashMap(){
            initBuckets(DEFAULT_CAPACITY);
        }
        public int size(){  //return the entries in the map
            return n;
        }
        public void put(K key, V value){ //Insert/Update  
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket,key);
            if(ei == -1){ // key doesn't exist, we have to insert a new node
                Node node = new Node(key, value);
                currBucket.add(node);
                n++;
            }else{ //we have to update the value associated with given key
                Node currNode = currBucket.get(ei);
                currNode.value = value;
            }

            if(n >= buckets.length * DEFAULT_LOAD_FACTOR){
                rehash();
            }
        }
        public V get(K key){ //It return the value associated with given key else null
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket,key);
            if(ei != -1){ // it means that key exists in mp
                Node currNode = currBucket.get(ei);
                return currNode.value;
            }
            return null;
        }
        public V remove(K key){ // return K key exist in map or not and also remove it from the map
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket,key);
            if(ei != -1){ //it means that key exists in mp
                Node currNode = currBucket.get(ei);
                V val = currNode.value;
                currBucket.remove(ei);
                n--;
                return val;
            }
            return null;
        }
    }
    public static void main(String[] args) {
        MyHashMap<String, Integer> mp = new MyHashMap<>();

        System.out.println("Testing put");
        mp.put("a", 1);
        mp.put("b", 7);
        System.out.println("Capacity: " + mp.capacity());
        System.out.println("Load: " + mp.load());
        mp.put("c", 3);
        mp.put("x", 6);
        mp.put("y", 7);
        mp.put("c", 30);

        System.out.println("Testing size: "+ mp.size()); //3
        mp.put("c", 30);
        System.out.println("Testing size: "+ mp.size()); //3 size doesn't change

        System.out.println("Testing get:");
        System.out.println(mp.get("a")); //1
        System.out.println(mp.get("b")); //7

        System.out.println("Capacity: " + mp.capacity());
        System.out.println("Load: " + mp.load());
      /*   System.out.println(mp.get("c")); //30

        System.out.println("Testing remove: ");
        System.out.println(mp.remove("a")); //return 1 and remove that node
         System.out.println(mp.remove("a"));  // return null because it doesn't exist
        System.out.println(mp.get("a")); // return null because it doesn't exist */
    }
}
