import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by YLT on 2018/5/15.
 */
public class T225 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public T225() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.size() > 0){
            queue1.offer(x);
        }else {
            queue2.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue1.size() > 0){
            while (queue1.size() > 1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else {
            while (queue2.size() > 1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        int result;
        if (queue1.size() > 0){
            while (queue1.size() > 1){
                queue2.offer(queue1.poll());
            }
            result = queue1.peek();
            queue2.offer(queue1.poll());
            return result;
        }else {
            while (queue2.size() > 1){
                queue1.offer(queue2.poll());
            }
            result = queue2.peek();
            queue1.offer(queue2.poll());
            return result;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (queue1.size() ==0 && queue2.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
