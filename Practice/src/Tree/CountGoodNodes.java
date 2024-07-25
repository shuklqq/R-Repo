package Tree;


public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        int count = 0;
        count = PreorderTraverse(root, count , Integer.MIN_VALUE);
        return count;
    }

    public int PreorderTraverse (TreeNode root, int count , int currMax){
        if(root == null){
            return count;
        }
        if(root.val >= currMax){
            count++;
            currMax = root.val;
        }
        if(root.left != null){
            count = PreorderTraverse(root.left, count, currMax);
        }
        if(root.right != null){
            count = PreorderTraverse(root.right, count, currMax);
        }
        return count;
    }
}
