package DFS;

import java.util.ArrayList;
import java.util.List;

/*
You are maintaining a project that has n methods numbered from 0 to n - 1.

You are given two integers n and k, and a 2D integer array invocations, where invocations[i] = [ai, bi] indicates that method ai invokes method bi.

There is a known bug in method k. Method k, along with any method invoked by it, either directly or indirectly, are considered suspicious and we aim to remove them.

A group of methods can only be removed if no method outside the group invokes any methods within it.

Return an array containing all the remaining methods after removing all the suspicious methods. You may return the answer in any order. If it is not possible to remove all the suspicious methods, none should be removed.

 

Example 1:

Input: n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]

Output: [0,1,2,3]

Explanation:



Method 2 and method 1 are suspicious, but they are directly invoked by methods 3 and 0, which are not suspicious. We return all elements without removing anything.

Example 2:

Input: n = 5, k = 0, invocations = [[1,2],[0,2],[0,1],[3,4]]

Output: [3,4]

Explanation:



Methods 0, 1, and 2 are suspicious and they are not directly invoked by any other method. We can remove them.

Example 3:

Input: n = 3, k = 2, invocations = [[1,2],[0,1],[2,0]]

Output: []

Explanation:



All methods are suspicious. We can remove them.

 

Constraints:

1 <= n <= 105
0 <= k <= n - 1
0 <= invocations.length <= 2 * 105
invocations[i] == [ai, bi]
0 <= ai, bi <= n - 1
ai != bi
invocations[i] != invocations[j]
*/
public class RemoveMethodsFromProject {

    // O(n + m) time, O(n + m) space. Flat CSR adjacency (no List<List<Integer>>, no boxing while
    // traversing) + iterative DFS, so a 10^5-deep invocation chain can't blow the call stack.
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int m = invocations.length;

        // Build CSR in one counting-sort pass: out-edges of v are to[start[v] .. start[v + 1]).
        int[] start = new int[n + 1];
        for (int[] e : invocations) start[e[0] + 1]++;
        for (int v = 0; v < n; v++) start[v + 1] += start[v];
        int[] to = new int[m];
        int[] cursor = new int[n];
        System.arraycopy(start, 0, cursor, 0, n);
        for (int[] e : invocations) to[cursor[e[0]]++] = e[1];

        // Phase 1: iterative DFS from k -> the suspicious closure.
        boolean[] suspicious = new boolean[n];
        int[] stack = new int[n];               // each node is pushed at most once
        int sp = 0, suspCount = 1;
        suspicious[k] = true;
        stack[sp++] = k;
        while (sp > 0) {
            int v = stack[--sp];
            for (int i = start[v]; i < start[v + 1]; i++) {
                int u = to[i];
                if (!suspicious[u]) {
                    suspicious[u] = true;
                    suspCount++;
                    stack[sp++] = u;
                }
            }
        }

        // Phase 2: a single edge from a clean method into the closure blocks the whole removal.
        // Only clean nodes are scanned here, so phases 1 and 2 together touch each edge exactly once.
        boolean blocked = false;
        outer:
        for (int v = 0; v < n; v++) {
            if (suspicious[v]) continue;        // suspicious -> suspicious is allowed
            for (int i = start[v]; i < start[v + 1]; i++) {
                if (suspicious[to[i]]) {
                    blocked = true;
                    break outer;
                }
            }
        }

        // Exact-capacity list, so no regrowth/copying while filling.
        List<Integer> remaining = new ArrayList<>(blocked ? n : n - suspCount);
        for (int v = 0; v < n; v++) {
            if (blocked || !suspicious[v]) remaining.add(v);
        }
        return remaining;
    }
}
