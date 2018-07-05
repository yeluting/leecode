import java.util.List;

/**
 * Created by YLT on 2017/10/27.
 */
public class T206 {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p =reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode new_head = null;
        while ( head !=  null) {
            ListNode next = head.next;
            head.next = new_head;
            new_head = head;
            head = next;
        }
        return new_head;
    }
}
