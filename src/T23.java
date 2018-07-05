/**
 * Created by YLT on 2018/3/23.
 */
public class T23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        if (lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }

        int mid = lists.length/2;

        ListNode[] listChild1 = new ListNode[mid];
        ListNode[] listChild2 = new ListNode[lists.length - mid];

        for (int i = 0 ;i < mid; i ++){
            listChild1[i] = lists[i];
        }
        for (int i = mid; i < lists.length;i ++){
            listChild2[i-mid] = lists[i];
        }

        ListNode result1 = mergeKLists(listChild1);
        ListNode result2 = mergeKLists(listChild2);
        return mergeTwoLists(result1,result2);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
