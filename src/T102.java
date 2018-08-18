import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by YLT on 2018/8/3.
 */
public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        int nowLen = 1, nextLen = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        List<Integer> nowPath = new ArrayList<>();
        while (nowLen > 0 && !nodes.isEmpty()){
            TreeNode now = nodes.poll();
            nowPath.add(now.val);
            nowLen --;
            if (now.left != null){
                nodes.add(now.left);
                nextLen ++;
            }
            if (now.right != null){
                nodes.add(now.right);
                nextLen ++;
            }
            if (nowLen == 0){
                result.add(new ArrayList<>(nowPath));
                nowPath.clear();
                nowLen = nextLen;
                nextLen = 0;
            }
        }
        return result;
    }
}
