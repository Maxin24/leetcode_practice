public class Offer24 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }

        if(head.next==null){
            return head;
        }

        ListNode temp=head.next;
        head.next=null;
        while(temp!=null){
            ListNode temp1=temp.next;
            temp.next=head;
            head=temp;
            temp=temp1;
        }
        return head;
    }
}
