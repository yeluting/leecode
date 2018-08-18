/*
import java.util.LinkedList;
import java.util.Queue;

*/
/**
 * Created by YLT on 2018/8/3.
 *//*

public class T116 {
    public void connect(TreeLinkNode root) {
        if(root == null)  return;
        int now = 1, next = 0;
        Queue<TreeLinkNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            TreeLinkNode nowNode = nodes.poll();
            if (now == 1){
                nowNode.next = null;
            }else {
                nowNode.next = nodes.peek();
            }
            if (nowNode.left != null) {
                nodes.add(nowNode.left);
                next ++;
            }
            if (nowNode.right != null) {
                nodes.add(nowNode.right);
                next ++;
            }
            now --;
            if (now == 0){
                now = next;
                next = 0;
            }
        }
    }
}
*/
