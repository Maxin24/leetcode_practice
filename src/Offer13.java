

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:LiuJX
 * @Date:2021/6/16
 * @Description:
 */
public class Offer13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] isVisited=new boolean[m][n];
        int[] dx=new int[]{-1,1,0,0};
        int[] dy=new int[]{0,0,1,-1};

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0,0});
        int res=0;
        while(!queue.isEmpty()){
            int[] tempArr=queue.poll();
            int x=tempArr[0];
            int y=tempArr[1];
            if(x<0 || y<0 || x>=m || y>=n || isVisited[x][y] || check(x,y,k)){
                continue;
            }

            isVisited[x][y]=true;
            res++;


            for(int i=0;i<4;i++){
                queue.offer(new int[]{x+dx[i],y+dy[i]});
            }
        }
        return res;
    }

    public boolean check(int x,int y,int k){
        int temp=0;
        while(x!=0){
            temp+=x%10;
            x/=10;
        }

        while(y!=0){
            temp+=y%10;
            y/=10;
        }

        return temp>k;
    }
}
