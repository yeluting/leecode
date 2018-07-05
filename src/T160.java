/**
 * Created by YLT on 2018/2/26.
 */
public class T160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = findLength(headA);
        int lengthB = findLength(headB);

        int count = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB){
            headA = walkForward(headA,count);
        }else {
            headB = walkForward(headB,count);
        }

        while (headA != headB){
            if (headA == headB){
                return headA;
            }else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    int findLength(ListNode headA){
        int length = 0;
        while (headA != null){
            length ++;
            headA = headA.next;
        }
        return length;
    }

    ListNode walkForward(ListNode headA, int step){
        while (step > 0){
            step --;
            headA = headA.next;
        }
        return headA;
    }
}
