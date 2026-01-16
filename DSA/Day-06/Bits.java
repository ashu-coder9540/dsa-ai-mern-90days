
public class Bits {
      // get ith bit
    static void getBit(int n, int pos){
        int bitMask = 1 << pos;

        if((bitMask & n) == 0){
            System.out.println("Bit was zero");
        } else{
            System.out.println("Bit was one");
        }
    }
    // set ith bit
    static int setBit(int n, int pos){
        int bitMask = 1 << pos;
        return n | bitMask;
    }

    // clear ith bit
    static int clearBit(int n, int pos){
        int bitMask = ~(1 << pos);
        return n & bitMask;
    }

    // update ith bit
    static int updateBit(int n, int pos, int oper){
        if(oper == 1){
            return setBit(n, pos);
        } else{
            return clearBit(n, pos);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int pos = 1;
        // getBit(n, pos);
        // int setBit = setBit(n, pos);
        // System.out.println(setBit);
        // int clearBit =clearBit(n, pos);
        // System.out.println(clearBit);

        int updateBit = updateBit(n, pos, 1);
        System.out.println(updateBit);
    }
}
