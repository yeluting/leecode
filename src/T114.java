/**
 * Created by YLT on 2018/3/23.
 */
public class T114 {
   /* private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);
        root.left = null;
        root.right = prev;
        prev = root;
    }

    public void preorder(TreeNode root, TreeNode last){


    }*/


   public static void main(String []args){
       TreeNode a = new TreeNode(1);
       TreeNode b = new TreeNode(2);
       TreeNode c = new TreeNode(5);
       TreeNode d = new TreeNode(3);
       TreeNode e = new TreeNode(4);
       TreeNode f = new TreeNode(6);

       a.left = b;
       a.right = c;
       b.left = d;
       b.right = e;
       c.right = f;
       T114 t114 = new T114();
       t114.flatten(a);

       while (a!=null){
           System.out.println(a.val);
           a=a.right;
       }
   }

    public void flatten(TreeNode root) {
        preorder(root,null);
    }

    public void preorder(TreeNode root,TreeNode last){
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){
            last = root;
            return;
        }

        TreeNode left_copy = root.left;
        TreeNode right_copy = root.right;
        TreeNode left_last = null;
        TreeNode right_last = null;


        if (root.left!=null) {
            preorder(root.left, left_last);
            root.left = null;
            root.right = left_copy;
            last = left_last;
        }

        if (root.right!=null) {
            preorder(root.right, right_last);
            if (left_last != null) {
                left_last.right = right_copy;
            }
            last = right_last;
        }
    }
}
