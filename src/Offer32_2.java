import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();

        Queue<TreeNode> tempQueue=new LinkedList<TreeNode>(){{
            add(root);
        }};
        Queue<Queue<TreeNode>> queue=new LinkedList<Queue<TreeNode>>(){{
            add(tempQueue);
        }};
        while(!queue.isEmpty()){
            Queue<TreeNode> queue1=queue.poll();
            Queue<TreeNode> newQueue=new LinkedList<>();
            List<Integer> newList=new LinkedList<>();
            while(!queue1.isEmpty()){
                TreeNode node=queue1.poll();
                newList.add(node.val);
                if(node.left!=null){
                    newQueue.add(node.left);
                }
                if(node.right!=null){
                    newQueue.add(node.right);
                }
            }
            if(!newList.isEmpty()){
                res.add(newList);
            }
            if(!newQueue.isEmpty()){
                queue.add(newQueue);
            }
        }
        return res;
    }
}
