/**
 * Created by YLT on 2017/11/6.
 */
public class T2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode now = new ListNode(0);
        ListNode result = now;
        while (l1 != null || l2 != null){
            int x = (l1 == null)? 0 : l1.val;
            int y = (l2 == null)? 0 : l2.val;
            int sum = flag + x + y;
            result.next = new ListNode(sum % 10);
            result = result.next;
            flag = sum / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(flag == 1) result.next = new ListNode(1);
        return now.next;
    }
}
