import java.util.HashMap;
import java.util.Stack;

/**
 * Created by apple on 2018/6/26.
 */
public class T20 {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(']','[');map.put(')','(');map.put('}','{');
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0;i < length; i ++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else if(stack.empty() || stack.pop() != map.get(s.charAt(i))){
                return false;
            }
        }
        return stack.empty()?true:false;
    }
}
