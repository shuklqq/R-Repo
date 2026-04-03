package Tree;

public class PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        long sum = 0;
        int count = 0;
        count = AllNodesTraversal(root, targetSum, count, sum);
        return count;
    }

    private int AllNodesTraversal(TreeNode root, int targetSum, int count, long sum) {
        if (root == null) {
            return count;
        }
        count = PreOrderTraversal(root, targetSum, count, sum);
        if (root.left != null) {
            count = AllNodesTraversal(root.left, targetSum, count, sum);
        }
        if (root.right != null) {
            count = AllNodesTraversal(root.right, targetSum, count, sum);
        }
        return count;
    }

    public int PreOrderTraversal(TreeNode root, int targetSum, int count, long sum) {
        if (root == null) {
            return count;
        }
        sum = sum + root.val;
        if (sum == targetSum) {
            count++;
        }
        System.out.println("Sum : " + sum);

        if (root.left != null) {
            count = PreOrderTraversal(root.left, targetSum, count, sum);
        }
        if (root.right != null) {
            count = PreOrderTraversal(root.right, targetSum, count, sum);
        }
        return count;
    }
}
