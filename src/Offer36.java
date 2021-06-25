public class Offer36 {
    Node pre=null;
    Node head=null;
    boolean tag=false;

    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }

        preOrder(root);
        head.left=pre;
        pre.right=head;
        return head;
    }

    public void preOrder(Node root){
        if(root==null){
            return;
        }

        preOrder(root.left);
        if(!tag){
            tag=true;
            head=root;
        }

        if(pre!=null){
            pre.right=root;
            root.left=pre;
        }
        pre=root;
        preOrder(root.right);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};