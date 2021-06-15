public class Offer13 {
    int res=0;
    boolean[][] isUsed;
    public int movingCount(int m, int n, int k) {
        isUsed=new boolean[m][n];

    }

    public void dfs(int m,int n,int i,int j,int k){
        if(i<0 || j<0 || i>m-1 || j>m-1 || isUsed[i][j] || check(i,j,k)){
            return;
        }

        isUsed[i][j]=true;
        res++;


    }


    public boolean check(int i,int j,int k){
        int temp=0;
        while(i!=0){
            temp+=i%10;
            i/=10;
        }
        while(j!=0){
            temp+=j%10;
            j/=10;
        }
        return temp > k;
    }
}
