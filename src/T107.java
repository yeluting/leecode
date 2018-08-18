import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by YLT on 2018/8/4.
 */
public class T107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int now = 1;
        int next = 0;
        List<Integer> nowPath = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode nowNode = queue.poll();
            now --;
            nowPath.add(nowNode.val);
            if (nowNode.left != null){
                queue.add(nowNode.left);
                next++;
            }
            if (nowNode.right != null){
                queue.add(nowNode.right);
                next++;
            }
            if (now == 0){
                now = next;
                next = 0;
                result.add(0,new ArrayList<>(nowPath));
                nowPath.clear();
            }
        }
        return result;
    }

}
