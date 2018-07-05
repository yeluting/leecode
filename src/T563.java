/**
 * Created by YLT on 2017/10/16.
 */
public class T563 {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        research(root);
        return tilt;
    }
    public int research(TreeNode node){
        int sum = 0;
        if(node != null){
            sum = sum + node.val;
            int sum1 = research(node.left);
            int sum2 = research(node.right);
            sum = sum + sum1 + sum2;
            tilt += Math.abs(sum1 - sum2);
        }
        return sum;
    }
}
