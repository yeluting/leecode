/**
 * Created by YLT on 2017/10/23.
 */
public class T111 {
    //刚开始没有注意到根结点的情况
 /*   public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        else if(root.right == null){
            return 1 + minDepth(root.left);
        }
      else if(root.left == null){
            return 1 + minDepth(root.right);
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }*/
    /*public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0)?left + right + 1:Math.min(left,right) + 1;
    }*/

    int min;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        min=Integer.MAX_VALUE;
        travesal(root, 1);//题目规定的root深度为1
        return min;
    }
    private void travesal(TreeNode x, int d){
        if(x==null || d>=min) return;//这道题加星标也主要是觉得自己这里d>=min就返回比较巧妙，击败了99.2%
        if(x.left==null && x.right==null) min=d;
        travesal(x.left, d+1);
        travesal(x.right, d+1);
    }
}
