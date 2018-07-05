/**
 * Created by apple on 2017/11/20.
 */
public class T141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode pre = head,behind = head;
        while (pre != null && behind != null){
            pre = pre.next;
            if(pre != null){
                pre = pre.next;
            }
            behind = behind.next;

            if(pre == behind){
                return true;
            }
        }
        return false;
    }
}
