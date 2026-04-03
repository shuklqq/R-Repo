package Tree;

public class MaximumDepthOfABinaryTree {
    public int maxDepth(TreeNode root) {
        int leftDepth = 0,rightDepth = 0;
        if( root == null){
            return 0;
        }
        leftDepth = maxDepth(root.left) + 1;
        rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }
}
