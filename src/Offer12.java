public class Offer12 {
    int x,y;
    public boolean exist(char[][] board, String word) {


        x=board.length;
        y=board[0].length;


        char c=word.charAt(0);
        int i,j;
        for(i=0;i<x;i++){
            for(j=0;j<y;j++){
                if(board[i][j]==c){
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word,int i,int j,int cnt){
        if( i<0 || j<0 || i>x-1 || j>y-1 || word.charAt(cnt)!=board[i][j]){
            return false;
        }

        if(cnt==word.length()-1){
            return true;
        }



        //注意这里 用'\0‘可以省去大量空间
        board[i][j]='\0';
        boolean res=dfs(board,word,i+1,j,cnt+1) ||dfs(board,word,i,j+1,cnt+1)||dfs(board,word,i-1,j,cnt+1)||dfs(board,word,i,j-1,cnt+1);
        board[i][j]=word.charAt(cnt);
        return res;
    }
}