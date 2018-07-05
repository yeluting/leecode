import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by YLT on 2018/3/23.
 */
public class T113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> path = new Stack<>();
        int preValue = 0;
        preorder(root,sum,path,preValue,result);
        return result;
    }


    public void preorder(TreeNode root, int sum, Stack<Integer> path,int preValue,List<List<Integer>> result){
        if (root == null){
            return ;
        }

        path.push(root.val);
        preValue += root.val;

        if (root.left == null && root.right == null && preValue == sum){

            //attention!!!!
            result.add(new ArrayList<>(path));
        }

        preorder(root.left,sum,path,preValue,result);
        preorder(root.right,sum,path,preValue,result);

        preValue -= root.val;
        path.pop();
    }
}
