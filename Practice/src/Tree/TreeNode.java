package Tree;

import com.sun.source.tree.Tree;

public class TreeNode {
    public int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public  TreeNode getLeft(){
        return this.left;
    }
    public  TreeNode getRight(){
        return this.right;
    }
}
