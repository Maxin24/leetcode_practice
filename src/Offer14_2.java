import java.math.BigInteger;

public class Offer14_2 {
    private static final int p=1000000007;
    public int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        long rem = 1, x = 3;
//        for(int a = n / 3 - 1; a > 0; a /= 2) {
//            if(a % 2 == 1) {
//                rem = (rem * x) % p;
//            }
//            x = (x * x) % p;
//        }
        rem=quickPow(3,n/3-1);

        if(b == 0) {
            return (int)(rem * 3 % p);
        }
        if(b == 1) {
            return (int)(rem * 4 % p);
        }
        return (int)(rem * 6 % p);
    }

    public long quickPow(int x,int n){
        if(n==0){
            return 1;
        }

        if(n%2!=0){
            return quickPow(x,n-1)*x%p;
        }else{
            return quickPow(x,n/2)*quickPow(x,n/2)%p;
        }
    }
}
