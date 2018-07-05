/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

*/
/**
 * Created by YLT on 2017/10/19.
 *//*

public class T437 {
    //简直没思路，我的死脑筋啊。。。。
    //想出这种简单的解法已经很不错啦
   */
/* int num = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        search(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return num;
    }

    public void search (TreeNode node,int sum){
        if(node == null){
            return;
        }
        if(node.val == sum){
            num ++;
        }
        search(node.left,sum - node.val);
        search(node.right,sum - node.val);
    }*//*


    */
/*public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }*//*


    Queue<TreeNode> nodes = new LinkedList<>();
    Queue<ArrayList<Integer>> times = new LinkedList<>();
    int number = 0;

    public int pathSum(TreeNode root, int sum) {
        times.add(new HashMap<>(0,0));
        search(root);
        while (! nodes.isEmpty()){

        }
    }

    public void search(TreeNode node){
        if(node == null) return;
        nodes.add(node);
        ArrayList<Integer> list = times.poll();

        search(node.left);
        search(node.right);
    }
}
*/
