public class Offer28 {
    public boolean preOrder(TreeNode a,TreeNode b){
        if(a==null && b==null){
            return true;
        }else if(a==null || b==null){
            return false;
        }else{
            return a.val==b.val && preOrder(a.left,b.right) && preOrder(a.right,b.left);
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return preOrder(root,root);
    }
}
