import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32_1 {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<Integer> nodeList=new LinkedList<>();
        myLevelOrder(root,queue,nodeList);
        while(!queue.isEmpty()){
            myLevelOrder(queue.poll(),queue,nodeList);
        }
        int[] res=new int[nodeList.size()];
        int i=0;
        for(Integer val:nodeList){
            res[i++]=val;
        }
        return res;

    }
    public void myLevelOrder(TreeNode node,Queue<TreeNode> queue,List<Integer> nodeList){
        if(node!=null){
            nodeList.add(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }
    }
}
