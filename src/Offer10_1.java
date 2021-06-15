public class Offer10_1 {
    private static int[] result=new int[101];
    static{
        result[0]=0;
        result[1]=1;
        for(int i=2;i<=100;i++){
            result[i]=(result[i-1]+result[i-2])%1000000007;
        }
    }
    public int fib(int n) {
        if(n<0){
            return -1;
        }
        return result[n];
    }
}
