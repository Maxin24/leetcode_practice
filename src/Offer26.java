import java.util.LinkedList;
import java.util.List;

public class Offer26 {
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if(b==null){
            return false;
        }

        List<TreeNode> nodeList=new LinkedList<>();
        preOrder(a,b.val,nodeList);
        for(TreeNode node:nodeList){
            if(check(node,b)){
                return true;
            }
        }
        return false;
    }

    private void preOrder(TreeNode a,int val,List<TreeNode> nodeList){
        if(a==null){
            return;
        }

        if(a.val==val){
            nodeList.add(a);
        }
        preOrder(a.left,val,nodeList);
        preOrder(a.right,val,nodeList);
    }

    private boolean check(TreeNode a,TreeNode b){
        if(b!=null){
            if(a!=null){
                if(a.val==b.val){
                    return check(a.left, b.left) && check(a.right, b.right);
                }else{
                    return false;
                }
            }else{
                return false;
            }

        }else{
            return true;
        }
    }
}
