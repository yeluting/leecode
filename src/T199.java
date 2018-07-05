import jdk.internal.util.xml.impl.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by YLT on 2018/3/25.
 */
public class T199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root,result,0);
        return result;
    }

    public void rightView(TreeNode node, List<Integer> result, int depth){
        if (node == null){
            return;
        }
        if (result.size() == depth){
            result.add(node.val);
        }

        rightView(node.right,result,depth + 1);
        rightView(node.left,result,depth + 1);
    }
}
