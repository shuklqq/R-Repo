package Tree;

public class BinarySearchTreeImplementation {

    // Insert New Node
    public TreeNode insertNode(TreeNode root, int value){
        if(root == null){
            return new TreeNode(value);
        }
        if(value > root.val){
            root.right = insertNode(root.right, value);
        } else if (value < root.val) {
            root.left = insertNode(root.left, value);
        }
        return root;
    }

    // Get node with the Minimum Value
    public TreeNode minValueNode(TreeNode root){
        while(root.left != null) root = root.left;
        return root;
    }

    // Get node with the Maximum value
    public TreeNode maxValueNode(TreeNode root){
        while(root.right != null) root = root.right;
        return root;
    }

    // Delete Node according to the mentioned key
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
}
