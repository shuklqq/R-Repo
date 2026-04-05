package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> l1 = new LinkedList<>();
        Queue<TreeNode> l2 = new LinkedList<>();
        ArrayList<Integer> sum = new ArrayList<>();
        int levelSum = 0;

        if(root == null){
            return 0;
        }
        l1.add(root);
        while(!l1.isEmpty()){
            TreeNode temp = l1.poll();

            if(temp.left != null){
                l2.add(temp.left);
            }

            if(temp.right != null){
                l2.add(temp.right);
            }
            levelSum += temp.val;
            if(l1.isEmpty()){
                sum.add(levelSum);
                levelSum = 0;
                l1 = l2;
                l2 = new LinkedList<>();
            }
        }
        int maxIndex = 0;
        for(int a = 0 ; a < sum.size() ; a++){
            if(sum.get(a) > sum.get(maxIndex)){
                maxIndex = a;
            }
        }
        return maxIndex + 1;
    }
}
