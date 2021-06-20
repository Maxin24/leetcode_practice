import java.util.LinkedList;
import java.util.List;

public class Offer32_3 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(0,root);
        return res;
    }

    public void dfs(int level,TreeNode node){
        if(node==null){
            return;
        }

        if(res.size()<=level){
            res.add(new LinkedList<>());
        }

        if(((level+1)&1)==1){
            res.get(level).add(node.val);
        }else{
            res.get(level).add(0,node.val);
        }

        dfs(level+1,node.left);
        dfs(level+1,node.right);
    }
}
