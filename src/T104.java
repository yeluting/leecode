/**
 * Created by YLT on 2017/10/23.
 */
public class T104 {
    //easy
    //二叉树的深度
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max( maxDepth(root.right),maxDepth(root.left));
    }
}
