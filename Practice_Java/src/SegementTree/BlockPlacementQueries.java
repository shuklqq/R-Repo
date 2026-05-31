package SegementTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
There exists an infinite number line, with its origin at 0 and extending towards the positive x-axis.

You are given a 2D array queries, which contains two types of queries:

For a query of type 1, queries[i] = [1, x]. Build an obstacle at distance x from the origin. It is guaranteed that there is no obstacle at distance x when the query is asked.
For a query of type 2, queries[i] = [2, x, sz]. Check if it is possible to place a block of size sz anywhere in the range [0, x] on the line, such that the block entirely lies in the range [0, x]. A block cannot be placed if it intersects with any obstacle, but it may touch it. Note that you do not actually place the block. Queries are separate.
Return a boolean array results, where results[i] is true if you can place the block specified in the ith query of type 2, and false otherwise.

 

Example 1:

Input: queries = [[1,2],[2,3,3],[2,3,1],[2,2,2]]

Output: [false,true,true]

Explanation:



For query 0, place an obstacle at x = 2. A block of size at most 2 can be placed before x = 3.

Example 2:

Input: queries = [[1,7],[2,7,6],[1,2],[2,7,5],[2,7,6]]

Output: [true,true,false]

Explanation:



Place an obstacle at x = 7 for query 0. A block of size at most 7 can be placed before x = 7.
Place an obstacle at x = 2 for query 2. Now, a block of size at most 5 can be placed before x = 7, and a block of size at most 2 before x = 2.
 

Constraints:

1 <= queries.length <= 15 * 104
2 <= queries[i].length <= 3
1 <= queries[i][0] <= 2
1 <= x, sz <= min(5 * 104, 3 * queries.length)
The input is generated such that for queries of type 1, no obstacle exists at distance x when the query is asked.
The input is generated such that there is at least one query of type 2.
*/
public class BlockPlacementQueries {

    private int[] maxGap;   // max gap between consecutive obstacles in this node's range
    private int[] leftmost; // leftmost obstacle position in range (-1 if none)
    private int[] rightmost;// rightmost obstacle position in range (-1 if none)
    private int N;

    // Step 4 (merge) applied bottom-up after every update
    private void pushUp(int node) {
        int L = 2 * node, R = 2 * node + 1;
        leftmost[node]  = leftmost[L]  != -1 ? leftmost[L]  : leftmost[R];
        rightmost[node] = rightmost[R] != -1 ? rightmost[R] : rightmost[L];
        maxGap[node]    = Math.max(maxGap[L], maxGap[R]);
        // cross-boundary gap: right side's leftmost - left side's rightmost
        if (rightmost[L] != -1 && leftmost[R] != -1)
            maxGap[node] = Math.max(maxGap[node], leftmost[R] - rightmost[L]);
    }

    // Step 6: point update — place obstacle at pos
    private void update(int node, int l, int r, int pos) {
        if (l == r) {                  // leaf: mark this position as an obstacle
            leftmost[node] = rightmost[node] = pos;
            maxGap[node] = 0;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) update(2 * node,     l,     mid, pos);
        else            update(2 * node + 1, mid + 1, r, pos);
        pushUp(node);                  // recompute this node from its children
    }

    // Step 7: range query — returns {maxGap, leftmost, rightmost} for [ql, qr]
    private int[] query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr)        // node fully inside query range
            return new int[]{maxGap[node], leftmost[node], rightmost[node]};
        int mid = (l + r) / 2;
        if (qr <= mid) return query(2 * node,     l,      mid, ql, qr);
        if (ql >  mid) return query(2 * node + 1, mid + 1, r,  ql, qr);
        // query spans both children — merge their results exactly like pushUp
        int[] Lres = query(2 * node,     l,      mid, ql, qr);
        int[] Rres = query(2 * node + 1, mid + 1, r,  ql, qr);
        int lm = Lres[1] != -1 ? Lres[1] : Rres[1];
        int rm = Rres[2] != -1 ? Rres[2] : Lres[2];
        int mg = Math.max(Lres[0], Rres[0]);
        if (Lres[2] != -1 && Rres[1] != -1)
            mg = Math.max(mg, Rres[1] - Lres[2]);
        return new int[]{mg, lm, rm};
    }

    public List<Boolean> getResults(int[][] queries) {
        // determine coordinate space size from max x across all queries
        int maxX = 0;
        for (int[] q : queries) maxX = Math.max(maxX, q[1]);
        N = maxX + 1;

        maxGap   = new int[4 * N];
        leftmost = new int[4 * N];
        rightmost= new int[4 * N];
        Arrays.fill(leftmost,  -1);   // -1 means no obstacle in this range yet
        Arrays.fill(rightmost, -1);

        update(1, 0, N - 1, 0);       // Step 2: 0 is always a permanent left boundary

        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                // Type 1: place obstacle — point update
                update(1, 0, N - 1, q[1]);
            } else {
                // Type 2: check if block of size sz fits in [0, x]
                int x = q[1], sz = q[2];
                int[] res = query(1, 0, N - 1, 0, x);
                int mg = res[0];
                // trailing gap: from rightmost obstacle to x (tree doesn't store this)
                if (res[2] != -1) mg = Math.max(mg, x - res[2]);
                result.add(mg >= sz);
            }
        }
        return result;
    }
}
