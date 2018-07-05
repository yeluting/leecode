import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by YLT on 2018/3/23.
 */
public class T236 {
    int finish = 0;
    Stack<TreeNode> Path = new Stack<>();
    List<TreeNode> end1 = new ArrayList<>();
    List<TreeNode> end2 = new ArrayList<>();
    List<TreeNode> end = new ArrayList<>();
    public static void main(String[]args){
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(0);
        TreeNode x = new TreeNode(8);
        TreeNode y = new TreeNode(7);
        TreeNode z = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = x;
        e.left = y;
        e.right = z;

        T236 solve = new T236();
        TreeNode result = solve.lowestCommonAncestor(a, b, y);
        System.out.println("lowestCommonAncestor = %d"+result.val);

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        searchNode(root,p,Path);
        end1 = new ArrayList<>(end);
        Path.clear();
        finish = 0;
        searchNode(root,q,Path);
        end2 = new ArrayList<>(end);

        int pathLen = end1.size() > end2.size()? end2.size():end1.size();

        int i;
        for ( i =0;i < pathLen;i ++){
            if (end1.get(i) != end2.get(i)){
                break;
            }
        }
        System.out.println(end1.size());
        return end1.get(i-1);
    }

    public  void searchNode(TreeNode root, TreeNode p, Stack<TreeNode> pPath){
        if (root == null || finish == 1){
            return;
        }
        pPath.push(root);

        if (root == p){
            finish = 1;
            end = new ArrayList<TreeNode>(pPath);
            return;
        }
        searchNode(root.left,p,pPath);
        searchNode(root.right,p,pPath);

        pPath.pop();
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root ==p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor1(root.left,p,q);
        TreeNode right = lowestCommonAncestor1(root.right,p,q);
        if (left == null){
            return right;
        }else if (right == null){
            return left;
        }else
            return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

    }
}
