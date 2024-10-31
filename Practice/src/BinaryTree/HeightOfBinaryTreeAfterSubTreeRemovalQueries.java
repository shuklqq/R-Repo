package BinaryTree;

import Tree.TreeNode;

import java.util.ArrayDeque;

/*

You are given the root of a binary tree with n nodes. Each node is assigned a unique value from 1 to n. You are also given an array queries of size m.

You have to perform m independent queries on the tree where in the ith query you do the following:

Remove the subtree rooted at the node with the value queries[i] from the tree. It is guaranteed that queries[i] will not be equal to the value of the root.
Return an array answer of size m where answer[i] is the height of the tree after performing the ith query.

Note:

The queries are independent, so the tree returns to its initial state after each query.
The height of a tree is the number of edges in the longest simple path from the root to some node in the tree.


Example 1:


Input: root = [1,3,4,2,null,6,5,null,null,null,null,null,7], queries = [4]
Output: [2]
Explanation: The diagram above shows the tree after removing the subtree rooted at node with value 4.
The height of the tree is 2 (The path 1 -> 3 -> 2).
Example 2:


Input: root = [5,8,9,2,1,3,7,4,6], queries = [3,2,4,8]
Output: [3,2,3,2]
Explanation: We have the following queries:
- Removing the subtree rooted at node with value 3. The height of the tree becomes 3 (The path 5 -> 8 -> 2 -> 4).
- Removing the subtree rooted at node with value 2. The height of the tree becomes 2 (The path 5 -> 8 -> 1).
- Removing the subtree rooted at node with value 4. The height of the tree becomes 3 (The path 5 -> 8 -> 2 -> 6).
- Removing the subtree rooted at node with value 8. The height of the tree becomes 2 (The path 5 -> 9 -> 3).


Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
m == queries.length
1 <= m <= min(n, 104)
1 <= queries[i] <= n
queries[i] != root.val

 */
public class HeightOfBinaryTreeAfterSubTreeRemovalQueries {
    /*
    Approach 1 : Breadth First Traversal, Storing the depth in two queues and not storing the element equal to query.
    Complexity Analysis :
        Time Complexity : O(n * m) - as there will n number of queries and for each query m iterations to get all the
            elements of the tree to get the depth of the tree.
        Space Complexity : The space complexity is the sum of the space required by the deques and the result array:
            O(N+len)
     */

   /* public int[] treeQueries(TreeNode root, int[] queries) {
        int len = queries.length;
        int[] ans = new int[len];
        for (int a = 0; a < len; a++) {
            ans[a] = findElementAndCalculateHeight(root, queries[a]);
        }
        return ans;
    }

    private int findElementAndCalculateHeight(TreeNode root, int query) {
        ArrayDeque<TreeNode> firstArrayDeque = new ArrayDeque<>();
        ArrayDeque<TreeNode> secondArrayDeque = new ArrayDeque<>();
        firstArrayDeque.push(root);
        int height = 0;
        while (!firstArrayDeque.isEmpty()) {
            TreeNode temp = firstArrayDeque.poll();
            if (temp.left != null && temp.left.val != query) {
                secondArrayDeque.push(temp.left);
            }
            if (temp.right != null && temp.right.val != query) {
                secondArrayDeque.push(temp.right);
            }
            if (firstArrayDeque.isEmpty() && !secondArrayDeque.isEmpty()) {
                height++;
                firstArrayDeque.addAll(secondArrayDeque);
                secondArrayDeque.clear();
            }
        }
        return height;
    }*/

    /*
    Approach 2 : Depth First Search for traversing the tree, not considering the node that has to be removed for
                height calculations.
    Complexity Analysis :
        Time Complexity : O(n*n), for worst case
        Space Complexity : O(n)
     */
    /*public int[] treeQueries(TreeNode root, int[] queries) {
        int len = queries.length;
        int[] ans = new int[len];
        for (int a = 0; a < len; a++) {
            ans[a] = findElementAndCalculateHeight(root.left, root.right, queries[a]);
        }
        return ans;
    }

    private int findElementAndCalculateHeight(TreeNode leftNode, TreeNode rightNode, int query) {
        int maxLeftHeight = -1;
        int maxRightHeight = -1;
        if(leftNode != null && leftNode.val != query){
            maxLeftHeight = findElementAndCalculateHeight(leftNode.left, leftNode.right, query);
        }
        if(rightNode != null && rightNode.val != query){
            maxRightHeight = findElementAndCalculateHeight(rightNode.left, rightNode.right, query);
        }
        return Integer.max(maxLeftHeight, maxRightHeight) + 1;
    }

     */
    /*
    Approach 3 : The above two approach are Brute force approach and can work pretty well for small dataset, but for
                large number of nodes, better would be to have a memorization logic using a data structure, either a
                HashMap or in our case due to constraints in the number of nodes, use a static array.
    Complexity Analysis :
        Time Complexity :
                Let's break down the time complexity of each part of the code:
                    maxHeightCalculationForPreOrderTraversal:
                        This function performs a recursive pre-order traversal, visiting each node once.
                        Since each recursive call is O(1), the total time complexity for this traversal is
                        O(n),
                        where n is the number of nodes in the tree.
                    maxHeightCalculationForReversePreOrderTraversal:
                        This function performs a reverse pre-order traversal, visiting each node once.
                        Similarly, the time complexity for this traversal is
                        O(n).
                    Main Function (treeQueries):The function iterates through the queries array once to populate ans.
                        The time complexity for this loop is
                        O(m), where m is the number of queries.Since m≤n, we can simplify this to
                        O(n).
                Overall Time Complexity: The combined time complexity is therefore:
                    O(n)+O(n)+O(m)=O(n)

        Space Complexity:
            Static Array maxHeightOfTreeAfterRemovingTheNode: This array has a fixed size of 10^6 +1,
                which is independent of the input size n. Therefore, it contributes
                O(1) space complexity.
            Recursion Stack: Each recursive traversal function (maxHeightCalculationForPreOrderTraversal
                and maxHeightCalculationForReversePreOrderTraversal) can have a maximum depth of O(h),
                where h is the height of the tree. For a balanced tree, h=O(logn), and for a skewed tree, h=O(n).
                Therefore, in the worst case, the space complexity for the recursion stack is O(n).
            Answer Array (ans): This array has a size m, contributing O(m) space complexity,
                which is O(n) in the worst case when m=n.
            Overall Space Complexity: The total space complexity is: O(1)+O(n)+O(m)=O(n)
    Summary
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    static final int[] maxHeightOfTreeAfterRemovingTheNode = new int[1000001];
    int currentMaxHeight = 0;

    public int[] treeQueries(TreeNode root, int[] queries) {

        maxHeightCalculationForPreOrderTraversal(root, 0);
        currentMaxHeight = 0;
        maxHeightCalculationForReversePreOrderTraversal(root, 0);

        int len = queries.length;
        int[] ans = new int[len];

        for (int a = 0; a < len; a++) {
            ans[a] = maxHeightOfTreeAfterRemovingTheNode[queries[a]];
        }
        return ans;
    }

    private void maxHeightCalculationForPreOrderTraversal(TreeNode node, int height) {
        if(node == null){
            return;
        }
        maxHeightOfTreeAfterRemovingTheNode[node.val] = currentMaxHeight;
        currentMaxHeight = Integer.max(currentMaxHeight, height);

        maxHeightCalculationForPreOrderTraversal(node.left, height + 1);
        maxHeightCalculationForPreOrderTraversal(node.right, height + 1);

    }
    private void maxHeightCalculationForReversePreOrderTraversal(TreeNode node, int height) {
        if(node == null){
            return;
        }
        maxHeightOfTreeAfterRemovingTheNode[node.val] =
                Integer.max(currentMaxHeight, maxHeightOfTreeAfterRemovingTheNode[node.val]);
        currentMaxHeight = Integer.max(currentMaxHeight, height);

        maxHeightCalculationForReversePreOrderTraversal(node.right, height + 1);
        maxHeightCalculationForReversePreOrderTraversal(node.left, height + 1);
    }
}
