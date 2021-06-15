import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        return buildNode(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildNode(int[] preorder,int[] inorder,int b1,int e1,int b2,int e2){
        if (b1 > e1) {
            return null;
        }
        TreeNode node=new TreeNode(preorder[b1]);
        int i=indexMap.get(preorder[b1]);

        int len=i-b2;
        node.left=buildNode(preorder,inorder,b1+1,b1+1+len-1,b2,i-1);
        node.right=buildNode(preorder,inorder,b1+1+len,e1,i+1,e2);
        return node;
    }
}
