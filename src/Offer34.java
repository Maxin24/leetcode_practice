import java.util.LinkedList;
import java.util.List;

public class Offer34 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
         List<Integer> list=new LinkedList<>();
         dfs(root,target,list,0);
         return res;
    }

    public void dfs(TreeNode root,int target,List<Integer> list,int currentVal){
        if(root==null){
            return;
        }

        int temp=currentVal+root.val;

        list.add(root.val);
        if(temp==target && root.left==null && root.right==null){
            List<Integer> tempList=new LinkedList<>(list);
            res.add(tempList);
            list.remove(list.size()-1);
            return;
        }

        dfs(root.left,target,list,temp);
        dfs(root.right,target,list,temp);
        list.remove(list.size()-1);

    }
}
