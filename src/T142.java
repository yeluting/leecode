/**
 * Created by apple on 2017/11/20.
 */
public class T142 {
    public ListNode hasCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode pre = head,behind = head;
        while (pre != null && behind != null){
            pre = pre.next;
            if(pre != null){
                pre = pre.next;
            }
            behind = behind.next;

            if(pre == behind){
                return pre;
            }
        }
        return null;
    }

    public ListNode getEntry(ListNode head){
        ListNode meeting = hasCycle(head);
        if(meeting == null) return null;

        ListNode now = meeting;
        int number = 1;
        while (now.next != meeting){
            number ++;
            now = now.next;
        }

        ListNode pre = head;
        for(int i = 0; i < number; i ++){
            pre = pre.next;
        }

        ListNode behind = head;
        while (behind!=pre){
            behind = behind.next;
            pre= pre.next;
        }
        return pre;
    }
}
