/**
 * Created by YLT on 2018/2/26.
 */
public class T92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        while (head == null || head.next == null){
            return head;
        }
        int count = n - m + 1;
        ListNode preHead = null;
        ListNode Head = head;
        while (m > 1){
            m --;
            preHead = Head;
            Head = Head.next;
        }


        ListNode root = Head;
        ListNode newHead = null;
        while (count > 1){
            ListNode next = Head.next;
            Head.next = newHead;
            newHead = Head;
            Head = next;
            count -- ;
        }

        root.next = Head;

        if (preHead != null){
            preHead.next = newHead;
            return head;
        }else {
            return newHead;
        }
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        int count = n - m + 1;
        ListNode result = head;//逆置后的头节点，非特殊情况下为head
        ListNode pre_node = null;

        while (m > 1 && head != null){
            pre_node = head;
            head = head.next;
            m --;
        }

        ListNode tail_node = head;
        ListNode new_head = null;
        while (count >= 1){
            ListNode next = head.next;
            head.next = new_head;
            new_head = head;
            head = next;
            count --;
        }

        tail_node.next = head;
        if (pre_node == null){
            result = new_head;
        }else {
            pre_node.next = new_head;
        }
        return result;

    }
}
