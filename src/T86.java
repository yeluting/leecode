/**
 * Created by YLT on 2018/2/26.
 */
public class T86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode head1 = null;
        ListNode temp1 = head1;
        ListNode head2 = null;
        ListNode temp2 = head2;

        while (head != null){
            if (head.val < x){
                if (head1 == null){
                    head1 = head;
                    temp1 = head1;
                }else {
                    temp1.next = head;
                    temp1 = temp1.next;
                }
            }else {
                if (head2 == null){
                    head2 = head;
                    temp2 = head2;
                }else {
                    temp2.next = head;
                    temp2 = temp2.next;
                }
            }
            head = head.next;
        }

        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }

        temp1.next = head2;
        temp2.next = null;
        return head1;
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode more = new ListNode(0);
        ListNode less = new ListNode(0);
        ListNode morePtr = more;
        ListNode lessPtr = less;

        while (head!= null){
            if (head.val < x){
                less.next = head;
                less = less.next;
            }else {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }

        less.next = morePtr.next;
        more.next = null;
        return lessPtr.next;
    }
}
