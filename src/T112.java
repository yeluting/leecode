/**
 * Created by YLT on 2017/10/23.
 */
public class T112 {
    //没有很明确的头绪
    //思考之后竟然有头绪，但是效率不高。果然思考是一件很神奇的事哦
  /*  boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        search(root,sum);
        return flag;
    }

    public void search (TreeNode node, int d){
        if(flag == true|| node == null) return;
        if(d == node.val && node.left == null && node.right == null){
            flag = true;
            return;
        }
        search(node.left,d - node.val);
        search(node.right,d - node.val);
    }*/
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && sum == root.val){
            return true;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }


}
