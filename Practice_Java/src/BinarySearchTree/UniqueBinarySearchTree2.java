package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTree2 {

    // start > end means "no subtree here"; one shared immutable instance, never mutated.
    private static final List<TreeNode> NO_SUBTREE = Collections.singletonList(null);

    public List<TreeNode> generateTrees(int n) {
        // (start, end) is bounded by 1..n, so a 2D array beats a HashMap key object:
        // O(1) indexing, no hashing, no boxing, no allocation per lookup.
        @SuppressWarnings("unchecked")
        List<TreeNode>[][] memo = new List[n + 2][n + 2];
        return allPossibleBST(1, n, memo);
    }

    private List<TreeNode> allPossibleBST(int start, int end, List<TreeNode>[][] memo) {
        if (start > end) {
            return NO_SUBTREE;
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        List<TreeNode> res = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTrees = allPossibleBST(start, i - 1, memo);
            List<TreeNode> rightSubTrees = allPossibleBST(i + 1, end, memo);
            for (TreeNode left : leftSubTrees) {
                for (TreeNode right : rightSubTrees) {
                    res.add(new TreeNode(i, left, right));
                }
            }
        }
        memo[start][end] = res;
        return res;
    }
}
