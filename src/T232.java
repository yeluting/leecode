import java.util.Stack;

/**
 * Created by YLT on 2018/5/16.
 */
public class T232 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    /** Initialize your data structure here. */
    public T232() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.size() == 0){
            while (stack1.size() > 0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.size() == 0){
            while (stack1.size() > 0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.size() ==0 && stack2.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
