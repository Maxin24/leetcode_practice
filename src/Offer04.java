/**
 * @author liujx
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }


        int rowLen= matrix.length;
        int columnLen=matrix[0].length;



        int i=0,j=columnLen-1;
        while(i<rowLen && j>=0){
            int val=matrix[i][j];
            if(val==target){
                return true;
            }else if(val<target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
