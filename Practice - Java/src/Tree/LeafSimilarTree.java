package Tree;

import java.util.LinkedList;

public class LeafSimilarTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> arr1 = new LinkedList<>();
        LinkedList<Integer> arr2 = new LinkedList<>();
        arr1 = InorderTraverse(root1, arr1);
        arr2 = InorderTraverse(root2, arr2);
        return arr1.equals(arr2);
    }
    public LinkedList<Integer> InorderTraverse(TreeNode root, LinkedList<Integer> list){
        if(root.left == null && root.right == null){
            list.add(root.val);
            System.out.println("Root Value :" + root.val + " | temp : " + list.getLast());
            return list;
        }
        if(root.left != null){
            list = InorderTraverse(root.left , list);
        }

        if(root.right != null){
            list = InorderTraverse(root.right, list);
        }
        return list;
    }
}
