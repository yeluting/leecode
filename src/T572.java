/**
 * Created by YLT on 2017/10/16.
 */
public class T572 {
    //t是否是s的一棵子树
    //没有好的思路，实现的算法效率比较低

    //法1：自己，按序遍历每一棵子树
    /*public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(s);
        while (!nodes.isEmpty()){
            TreeNode nowNode = nodes.poll();
            if(search(nowNode,t) == true) return true;
            if(nowNode!=null) {
                nodes.add(nowNode.left);
                nodes.add(nowNode.right);
            }
        }
        return false;
    }

    public boolean search(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return t1.val == t2.val && search(t1.left,t2.left) && search(t1.right,t2.right);
    }*/

    //前序遍历，看s序列是否包含t序列
/*    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = String.valueOf(preorder(s));
        String tree2 = String.valueOf(preorder(t));

        return tree1.indexOf(tree2) >= 0;
    }
    public StringBuffer preorder(TreeNode t) {
        if (t == null) {
            return new StringBuffer("null") ;
        }
        return  new StringBuffer("#").append(t.val).append(" ").append(preorder(t.left)).append(preorder(t.right));
    }*/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s != null && t != null) {
            if (s.val == t.val) {
                if (helper(s.left, t.left) && helper(s.right, t.right)) {
                    return true;
                }
            }
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return false;
    }

    public boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s != null && t != null) {
            if (s.val == t.val) {
                if (helper(s.left, t.left) && helper(s.right, t.right)) {
                    return true;
                }
            }
        }
        return false;
    }


}
