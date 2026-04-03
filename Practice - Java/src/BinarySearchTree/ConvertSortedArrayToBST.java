package BinarySearchTree;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode output = insert(nums, 0, nums.length - 1);
        return output;
    }

    public TreeNode insert (int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int middle = (right + left) / 2;
        TreeNode leftNode = insert(nums, left, middle - 1);
        TreeNode rightNode = insert(nums, middle+1, right);
        TreeNode root = new TreeNode(nums[middle], leftNode, rightNode);
        return root;
    }
}
