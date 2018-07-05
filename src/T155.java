import java.util.Stack;

/**
 * Created by YLT on 2018/5/16.
 */
public class T155 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    /** initialize your data structure here. */
    public T155() {
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.size() == 0){
            stack2.push(x);
        }else {
            if (stack2.peek() > x){
                stack2.push(x);
            }else {
                stack2.push(stack2.peek());
            }
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
