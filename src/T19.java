/**
 * Created by YLT on 2018/6/13.
 */
public class T19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0);
        result.next = head;

        int count = 0;
        ListNode first = result;
        while (count < n - 1){
            if (first != null){
                first = first.next;
                count ++;
            }else {
                return result;
            }
        }

        ListNode second = result;

        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return result.next;
    }
}
