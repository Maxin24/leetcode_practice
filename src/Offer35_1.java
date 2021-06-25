import java.util.HashMap;
import java.util.Map;

public class Offer35_1 {
    public RandomNode copyRandomList(RandomNode head) {
        if(head==null){
            return null;
        }
        Map<RandomNode,RandomNode> map=new HashMap<>();
        RandomNode current=head;
        while(current!=null){
            map.put(current,new RandomNode(current.val));
            current=current.next;
        }

        current=head;
        while(current!=null){
            map.get(current).next=map.get(current.next);
            if(current.random!=null){
                map.get(current).random=map.get(current.random);
            }
            current=current.next;
        }
        return map.get(head);
    }
}

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
