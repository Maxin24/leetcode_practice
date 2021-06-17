public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode front=head;
        while(k--!=0){
            front=front.next;
        }

        ListNode rare=head;
        while(front!=null){
            front=front.next;
            rare=rare.next;
        }
        return rare;
    }
}
