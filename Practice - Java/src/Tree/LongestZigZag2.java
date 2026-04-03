package Tree;

public class LongestZigZag2 {
    public int longestZigZag(TreeNode root) {
        int counter = 0;
        int maxLength = 0;
        int tempLength = 0;
        maxLength = NodeTraversal(root, counter, maxLength , tempLength);
        return maxLength;
    }

    private int NodeTraversal(TreeNode root, int counter, int maxLength, int tempLength) {
        if(root == null){
            return maxLength;
        }
        if(tempLength > maxLength){
            maxLength = tempLength;
        }
        if(counter == 0){
            maxLength = NodeTraversal(root.left, 1, maxLength, tempLength+1);
        }else{
            maxLength = NodeTraversal(root.left, 1, maxLength, 1);
        }

        if(counter == 1){
            maxLength = NodeTraversal(root.right, 0, maxLength, tempLength+1);
        }else{
            maxLength = NodeTraversal(root.right, 0, maxLength, 1);
        }
        return maxLength;
    }
}
