/**
 * Created by YLT on 2017/10/24.
 */
public class T203 {
    //删除val为指定值的节点
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;

        ListNode prenode = head;
        ListNode nownode = head.next;
        while (nownode != null){
            if(nownode.val == val){
                prenode.next = nownode.next;
                nownode = prenode.next;
            }else{
                prenode = nownode;
                nownode = nownode.next;
            }
        }

        if(head.val == val){
            head = head.next;
        }

        return head;
    }

   /* public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        if(head.val == val){
            return removeElements(head.next,val);
        }else {
            head.next = removeElements(head.next,val);
            return head;
        }
    }*/
}
