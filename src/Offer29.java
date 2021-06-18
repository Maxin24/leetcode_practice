public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0 ||matrix[0].length ==0){
            return new int[0];
        }

        int m=matrix.length;
        int n=matrix[0].length;
        int[] res=new int[m*n];

        int cnt=0,i=0,j=0,round=0;
        while(cnt<res.length){
            while(j<matrix[0].length-round){
                if(check(cnt,res.length)){
                    break;
                }
                res[cnt++]=matrix[i][j++];
            }

            i++;j--;
            while(i<matrix.length-round){
                if(check(cnt,res.length)){
                    break;
                }
                res[cnt++]=matrix[i++][j];
            }



            i--;j--;
            while(j>= round){
                if(check(cnt,res.length)){
                    break;
                }
                res[cnt++]=matrix[i][j--];
            }

            j++;i--;
            while(i>round){
                if(check(cnt,res.length)){
                    break;
                }
                res[cnt++]=matrix[i--][j];
            }
            i++;j++;
            round++;
        }
        return res;
    }

    private boolean check(int cnt,int len){
        if(cnt>=len){
            return true;
        }
        return false;
    }
}
