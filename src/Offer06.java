import java.util.Stack;

/**
 * @author liujx
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        int size=0;
        while(head!=null){
            stack.push(head.val);
            size++;
            head=head.next;
        }
        int i=0;
        int[] res=new int[size];
        while(!stack.empty()){
            res[i++]=stack.pop();
        }
        return res;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

