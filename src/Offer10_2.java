public class Offer10_2 {
    private static int[] res=new int[101];
    static{
        res[0]=0;
        res[1]=1;
        res[2]=2;
        for(int i=3;i<=100;i++){
            res[i]=(res[i-1]+res[i-2])%1000000007;
        }
    }
    public static int numWays(int n) {
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
