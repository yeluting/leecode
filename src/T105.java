/**
 * Created by YLT on 2018/8/3.
 */
public class T105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return build(preorder,0,preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int b1, int e1, int[] inorder, int b2, int e2){
        if (e1 < b1){
            return null;
        }
        int i;
        for (i = b2; i <= e2; i ++){
            if (inorder[i] == preorder[b1]){
                break;
            }
        }
        int len1 = i - b2;
        int len2 = e2 - i;
        TreeNode node = new TreeNode(preorder[b1]);
        if (len1 >=  1) {
            node.left = build(preorder, b1 + 1, b1 + 1 + len1, inorder, b2, i - 1);
        }
        if (len2 >= 1) {
            node.right = build(preorder, b1 + 2 + len1, e1, inorder, i + 1, e2);
        }
        return node;
    }
}
