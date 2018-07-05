import java.util.ArrayList;
import java.util.List;

/**
 * Created by YLT on 2017/10/13.
 */
public class T637 {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<TreeNode> nodeQuene = new ArrayList<>();
        int[] number = new int[10000000];
        int i = 0;

        nodeQuene.add(root);
        number[i++] = root.val;
        TreeNode nowNode;
        int top = 0;

        while (top < nodeQuene.size()) {
            nowNode = nodeQuene.get(top++);
            if (nowNode.left != null) {
                nodeQuene.add(nowNode.left);
                number[i++] = (nowNode.left.val);
            } else {
                number[i++] = Integer.MIN_VALUE;
            }
            if (nowNode.right != null) {
                nodeQuene.add(nowNode.right);
                number[i++] = (nowNode.right.val);
            } else {
                number[i++] = Integer.MIN_VALUE;
            }
        }

        List<Double> result = new ArrayList<>();
        int k = 0;
        int l = 0 ;
        while (l < i) {
            int sum = 0;
            int begin = 0;
            for (l = (int) (Math.pow(2, k) - 1); l < Math.pow(2, k + 1) - 1; l++) {
                if (number[l] != Integer.MIN_VALUE) {
                    sum += number[l];
                    begin++;
                }
            }
            result.add(((double) sum / begin));
        }
        return result;
    }
}
