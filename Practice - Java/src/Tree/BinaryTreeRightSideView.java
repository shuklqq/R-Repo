package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> lis = new LinkedList<>();
        Queue<TreeNode> lis2 = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        lis.add(root);
        System.out.println("lis 1: " + lis.peek().val);
        while(!lis.isEmpty()){
            TreeNode temp = lis.poll();
            System.out.println("temp: " + temp.val + " | temp left : " + temp.left + " | temp right : " + temp.right);
            if(temp.left != null){
                lis2.add(temp.left);
                System.out.println("lis 2: " + lis2.peek().val);
            }

            System.out.println("temp: " + temp.val + " | temp left : " + temp.left + " | temp right : " + temp.right);
            if(temp.right != null){
                lis2.add(temp.right);
                System.out.println("lis 3: " + lis2.peek().val);
            }

            if(lis.isEmpty()){
                result.add(temp.val);
                lis = lis2;
                lis2 = new LinkedList<>();
            }
        }
        return result;
    }
}
