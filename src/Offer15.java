public class Offer15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            res+=n&1;
            n>>>=1;
        }
        return n;
    }

    public int hammingWeight1(int n) {
        int res=0;
        while(n!=0){
            n&=(n-1);
            res++;

        }
        return n;
    }
}
