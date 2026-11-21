package InterviewPrep.Implementation.DFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
You are given a tree rooted at node 0 that consists of n nodes numbered from 0 to n - 1. The tree is represented by an array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.

You are also given a string s of length n, where s[i] is the character assigned to node i.

We make the following changes on the tree one time simultaneously for all nodes x from 1 to n - 1:

Find the closest node y to node x such that y is an ancestor of x, and s[x] == s[y].
If node y does not exist, do nothing.
Otherwise, remove the edge between x and its current parent and make node y the new parent of x by adding an edge between them.
Return an array answer of size n where answer[i] is the size of the subtree rooted at node i in the final tree.

 

Example 1:

Input: parent = [-1,0,0,1,1,1], s = "abaabc"

Output: [6,3,1,1,1,1]

Explanation:


The parent of node 3 will change from node 1 to node 0.

Example 2:

Input: parent = [-1,0,4,0,1], s = "abbba"

Output: [5,2,1,1,1]

Explanation:


The following changes will happen at the same time:

The parent of node 4 will change from node 1 to node 0.
The parent of node 2 will change from node 4 to node 1.
 

Constraints:

n == parent.length == s.length
1 <= n <= 105
0 <= parent[i] <= n - 1 for all i >= 1.
parent[0] == -1
parent represents a valid tree.
s consists only of lowercase English letters.

*/

import java.util.*;

class Solution {

    static class Frame {
        int node;
        boolean exit;

        Frame(int node, boolean exit) {
            this.node = node;
            this.exit = exit;
        }
    }

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        // STEP 1: Build original tree
        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        // STEP 2: Find new parents using iterative DFS
        int[] newParent = parent.clone();

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        int[] previousSeen = new int[n];

        Deque<Frame> stack = new ArrayDeque<>();
        stack.push(new Frame(0, false));

        while (!stack.isEmpty()) {

            Frame frame = stack.pop();
            int node = frame.node;

            int c = s.charAt(node) - 'a';

            if (!frame.exit) {

                // ENTER EVENT

                // Find closest matching ancestor
                if (lastSeen[c] != -1) {
                    newParent[node] = lastSeen[c];
                }

                // Save previous state
                previousSeen[node] = lastSeen[c];

                // Update latest node for this character
                lastSeen[c] = node;

                // Schedule EXIT event
                stack.push(new Frame(node, true));

                // Schedule children in reverse order
                List<Integer> childList = children[node];

                for (int i = childList.size() - 1; i >= 0; i--) {
                    stack.push(new Frame(childList.get(i), false));
                }

            } else {

                // EXIT EVENT

                // Restore previous character state
                lastSeen[c] = previousSeen[node];
            }
        }

        // STEP 3: Build modified tree
        List<Integer>[] newChildren = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            newChildren[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }

        // STEP 4: Iterative DFS to get traversal order
        List<Integer> order = new ArrayList<>();

        Deque<Integer> dfsStack = new ArrayDeque<>();
        dfsStack.push(0);

        while (!dfsStack.isEmpty()) {

            int node = dfsStack.pop();
            order.add(node);

            for (int child : newChildren[node]) {
                dfsStack.push(child);
            }
        }

        // STEP 5: Calculate subtree sizes in reverse order
        int[] answer = new int[n];

        for (int i = order.size() - 1; i >= 0; i--) {

            int node = order.get(i);

            answer[node] = 1;

            for (int child : newChildren[node]) {
                answer[node] += answer[child];
            }
        }

        return answer;
    }
}
