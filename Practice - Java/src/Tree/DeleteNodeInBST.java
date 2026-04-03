package Tree;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode temp = minValueNode(root.right);

            root.val = temp.val;
            root.right = deleteNode(root.right, temp.val);

        }
        return root;
    }

    private TreeNode minValueNode(TreeNode right) {

        TreeNode temp;
        if(right.left == null){
            return right;
        }
        temp = minValueNode(right.left);
        return temp;
    }
}
