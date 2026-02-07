import java.util.*;

public class MaxFreq {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 4, 1, 5, 2, 5, 1, 5, 3, 5, 2, 5, 1};
        Map<Integer, Integer> freq = new HashMap<>();
        for(var el: arr){
            if(!freq.containsKey(el)){
                freq.put(el,1);
            }else{
                freq.put(el, freq.get(el)+1);
            }
        }
        // till now we have created our freq map
        System.out.println("Frequency Map");
        System.out.println(freq.entrySet());

        int mxFreq=0, ansKey=-1;
       /*  for(var e: freq.entrySet()){
            if(e.getValue()>mxFreq){
                mxFreq = e.getValue();
                ansKey = e.getKey();
            }
        } */

        for(var k: freq.keySet()){
            if(freq.get(k)> mxFreq){
                mxFreq = freq.get(k);
                ansKey = k;
            }
        }
        System.out.printf("%d has maxFreq and it occurs %d times",ansKey,mxFreq);
    }
}
