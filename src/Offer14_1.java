public class Offer14_1 {
    public int cuttingRope(int n) {
        if(n<=3){
            return n-1;
        }

        switch (n%3){
            case 0:return (int)Math.pow(3,n/3);
            case 1:return ((int)Math.pow(3,n/3)-1)*4;
            case 2:return (int)Math.pow(3,n/3)*2;
            default:return -1;
        }
    }
}
