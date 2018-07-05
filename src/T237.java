/**
 * Created by YLT on 2017/10/24.
 */
class ListNode {
     int val;
     ListNode next;
    ListNode(int x) { val = x; }
  }

public class T237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
