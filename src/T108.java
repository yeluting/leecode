/**
 * Created by YLT on 2018/8/3.
 */
public class T108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1){
            return null;
        }
        return toTree(nums,0,nums.length-1);
    }

    public TreeNode toTree(int[] nums, int begin, int end){
        if (begin == end){
            return new TreeNode(nums[begin]);
        }else if (begin > end){
            return null;
        }

        int mid = (begin + end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = toTree(nums,begin,mid - 1);
        node.right = toTree(nums,mid + 1, end);
        return node;
    }
}
