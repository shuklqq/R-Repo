package Tree;

public class LongestZigZagPath {
    public int longestZigZag(TreeNode root) {
        int counter = 0;
        int maxLength = 0;
        int tempLength = 1;
        maxLength = NodeTraversal(root, counter, maxLength , tempLength);
        return maxLength;
    }

    private int NodeTraversal(TreeNode root, int counter, int maxLength , int tempLength) {
        if(root == null){
            return maxLength;
        }
        System.out.println("Root 1 : " + root.val + " | counter : " + counter + " | maxLength : " + maxLength + " | Temp Length : " + tempLength);
        tempLength = ZigZagTraversal(root, counter, tempLength);
        System.out.println("Root 2 : " + root.val + " | counter : " + counter + " | maxLength : " + maxLength + " | Temp Length : " + tempLength);
        if(tempLength > maxLength){
            maxLength = tempLength;
        }
        tempLength = 1;
        System.out.println("Root 3 : " + root.val + " | counter : " + counter + " | maxLength : " + maxLength + " | Temp Length : " + tempLength);
        tempLength = ZigZagTraversal(root, counter+1, tempLength);
        System.out.println("Root 4 : " + root.val + " | counter : " + counter + " | maxLength : " + maxLength + " | Temp Length : " + tempLength);
        if(tempLength > maxLength){
            maxLength = tempLength;
        }
        tempLength = 1;
        System.out.println("Root 5 : " + root.val + " | counter : " + counter + " | maxLength : " + maxLength + " | Temp Length : " + tempLength);
        if( root.left != null){
            maxLength = NodeTraversal(root.left, counter, maxLength, tempLength);
        }
        if( root.right != null){
            maxLength = NodeTraversal(root.right, counter, maxLength,tempLength);
        }
        return maxLength;
    }

    private int ZigZagTraversal(TreeNode root, int counter, int maxLength) {
        if(root == null){
            System.out.println("Root 6 : " + root.val + " | counter : " + counter + " | maxLength : " + maxLength);
            return maxLength;
        }
        if(counter == 0 && root.left != null){
            System.out.println("Root 7 : " + root.val + " | counter : " + counter + " | maxLength : " + maxLength);
            maxLength = ZigZagTraversal(root.left, 1, maxLength) + 1;
        }
        if(counter == 1 && root.right != null){
            System.out.println("Root 8 : " + root.val + " | counter : " + counter + " | maxLength : " + maxLength);
            maxLength = ZigZagTraversal(root.right, 0, maxLength) + 1;
        }
        System.out.println("Root 9 : " + root.val + " | counter : " + counter + " | maxLength : " + maxLength);
        return  maxLength;
    }
}
