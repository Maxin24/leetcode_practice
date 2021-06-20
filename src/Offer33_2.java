import java.util.Stack;

/**
 * 不是很理解 可以回头再好好看看
 * @author liujx
 */
public class Offer33_2 {
    public boolean verifyPostorder(int[] postorder) {
        int root=Integer.MAX_VALUE;
        Stack<Integer> stack=new Stack<>();
        for(int i=postorder.length-1;i>=0;i--){
            if(postorder[i]>root){
                return false;
            }
            while(!stack.empty() && stack.peek()>postorder[i]){
                root=stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

}
