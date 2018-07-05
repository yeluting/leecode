import java.util.Map;

/**
 * Created by YLT on 2017/10/23.
 */
public class T110 {
  /*  public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(maxDepth(root.right) - maxDepth(root.left)) >= 2){
            return false;
        }
        return isBalanced(root.right)&&isBalanced(root.left);
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max( maxDepth(root.right),maxDepth(root.left));
    }*/

    public boolean isBalanced(TreeNode root) {
        return search(root)!=-1;
    }

    public int search(TreeNode node){
        if(node == null){
            return 0;
        }
        int ll = search(node.left);
        if(ll == -1){
            return -1;
        }
        int rl = search(node.right);
        if(rl == -1){
            return -1;
        }
        if (Math.abs(ll - rl) > 1)  return -1;
        return Math.max(ll,rl)+1;
    }
}
