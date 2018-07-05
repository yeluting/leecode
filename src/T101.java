import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by YLT on 2017/10/18.
 */
public class T101 {
   /* public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return t1.val == t2.val && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }*/

    /*Queue<TreeNode> q = new LinkedList<>();

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t2 == null || t1 == null || t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }*/
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode root1,TreeNode root2){
        if (root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val){
            return false;
        }else {
            return isMirror(root1.left,root2.right)&& isMirror(root1.right,root2.left);
        }
    }

}
