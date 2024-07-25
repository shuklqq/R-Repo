package Tree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ansNode = null;
        ansNode = InOrderTraversal(root, p, q, ansNode);
        return ansNode;
    }

    private TreeNode InOrderTraversal(TreeNode root, TreeNode p, TreeNode q, TreeNode ansNode) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode l1 = null, l2 = null;

        l1 = InOrderTraversal(root.left, p, q, ansNode);

        l2 = InOrderTraversal(root.right, p, q, ansNode);

        if(l1 != null && l2 != null){
            ansNode = root;
        } else if (l1 == null && l2 != null) {
            ansNode = l2;
        } else if (l1 != null && l2 == null) {
            ansNode = l1;
        }
        return ansNode;
    }
}
