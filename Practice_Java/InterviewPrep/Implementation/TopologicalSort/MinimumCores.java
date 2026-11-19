package InterviewPrep.Implementation.TopologicalSort;
/*
Minimum Number of Cores

You are given n jobs numbered 0 to n-1. Job i takes time[i] units of time to run on a single core.

You are also given an array dependencies where dependencies[j] = [u, v] means job v can start
only after job u has finished. The dependency graph is a DAG (it has no cycles).

Every job starts as early as possible, i.e., at the moment all of its dependencies have finished.
A job with no dependencies starts at time 0.

A core runs one job at a time. A job that finishes at time t frees its core for another job
that starts at time t.

Return the minimum number of cores needed so that every job runs at its earliest possible start time.


Example 1:

Input: n = 6, time = [3,2,4,1,2,4], dependencies = [[0,2],[1,2],[1,3],[3,4]]
Output: 3
Explanation:
Job 0 runs [0,3), job 1 runs [0,2), job 5 runs [0,4).
Job 3 waits for job 1 and runs [2,3).
Job 2 waits for jobs 0 and 1 and runs [3,7).
Job 4 waits for job 3 and runs [3,5).
At most 3 jobs run at the same time (e.g., jobs 0, 1 and 5 during [0,2)), so 3 cores are needed.

Example 2:

Input: n = 3, time = [5,5,5], dependencies = []
Output: 3
Explanation: No job depends on another, so all three start at time 0 and run together.

Example 3:

Input: n = 3, time = [1,2,3], dependencies = [[0,1],[1,2]]
Output: 1
Explanation: The jobs form a chain, so only one job runs at any moment.


Constraints:

1 <= n <= 10^5
0 <= dependencies.length <= 2 * 10^5
dependencies[j].length == 2
0 <= u, v < n, u != v
1 <= time[i] <= 10^9
The dependency graph is a DAG.


Input Format (stdin):

Line 1: two integers n and m (number of jobs, number of dependencies)
Line 2: n space-separated integers time[0] ... time[n-1]
Next m lines: two integers u v, meaning job v depends on job u

Output Format (stdout):

A single integer: the minimum number of cores.

Sample Input (Example 1):
6 4
3 2 4 1 2 4
0 2
1 2
1 3
3 4

Sample Output:
3

*/
import java.io.*;
import java.util.*;

public class MinimumCores {

    public static int minCores(int n, int[] time, int[][] dependencies) {
        // TODO: solve
        return 0;
    }

    public static void main(String[] args) throws IOException {
        // TODO: read input from stdin, call minCores, print the result
    }
}
