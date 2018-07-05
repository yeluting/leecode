/**
 * Created by YLT on 2017/11/16.
 */
public class T21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode now = result;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){now.next = l1; l1 = l1.next;}
            else {now.next = l2; l2 = l2.next;}
            now = now.next;
        }
        now.next = l1 == null? l2 : l1;
        return result.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode end = result;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                result.next = l1;
                result = l1;
                l1 = l1.next;
            }else {
                result.next = l2;
                result = l2;
                l2 = l2.next;
            }
        }
        result.next = l1==null? l2 :l1;

        return end.next;
    }

}
