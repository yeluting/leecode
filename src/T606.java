

/**
 * Created by YLT on 2017/7/12.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class T606 {
    /*
    * tree,string
    * */
    public String tree2str1(TreeNode t) {
        StringBuffer str = new StringBuffer();
        if (t == null) {
            return "";
        } else {
            str.append(t.val);
            if (t.left != null) {
                str.append("(");
                str.append(tree2str1(t.left));
                str.append(")");
            }
            if (t.right != null && t.left == null) {
                str.append("()(");
                str.append(tree2str1(t.right));
                str.append(")");
            } else if (t.right != null && t.left != null) {
                str.append("(");
                str.append(tree2str1(t.right));
                str.append(")");
            }
            return str.toString();
        }
    }

    public String tree2str(TreeNode t) {
        StringBuffer str = new StringBuffer();
        if (t == null) {
            return "";
        } else {
            str.append(t.val);
            if (t.left != null || t.right != null) {
                str.append("(");
                str.append(tree2str(t.left));
                str.append(")");
                if (t.right != null) {
                    str.append("(");
                    str.append(tree2str(t.right));
                    str.append(")");
                }
            }
        }
        return str.toString();
    }

}
