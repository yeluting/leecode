import java.util.Scanner;
import java.util.Stack;

/**
 * Created by YLT on 2018/8/10.
 */
public class W1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        while (num!=1 && num!=2){
            if (num%2 == 1){
                stack.add(1);
                num = num/2;
            }else {
                stack.add(2);
                num = num/2 - 1;
            }
        }
        if (num == 1){
            stack.add(1);
        }else {
            stack.add(2);
        }
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
    }
}
