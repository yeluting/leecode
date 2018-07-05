import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by YLT on 2017/10/27.
 */
public class T234 {
    //链表一定要注意指针

    /*ArrayList<Integer> search = new ArrayList<>();
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        head = reverseList(head);
        int i = 0;
        while (head != null){
            if(head.val != search.get(i)){
                return false;
            }
            i ++;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode q = null;
        ListNode r;
        while (p != null){
            search.add(p.val);
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        return q;
    }*/

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        int count = 0;
        ListNode p = head;
        while (p != null){
            count ++;
            p = p.next;
        }

        p = head;
        ListNode q = null;
        ListNode r;
        int i = 0;
        while (i < count / 2){
            r = q;
            q = p;
            p = p.next;
            q.next = r;
            i ++;
        }

        ListNode head1 = q;
        ListNode head2;
        if(count %2 == 0){
            head2 = p;
        }else{
            head2 = p.next;
        }

        while (head1 != null){
            if(head1.val != head2.val){
                return false;
            }
        }
        return true;
    }
}
