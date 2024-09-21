/*

The Major Oak in Sherwood is known for its majestic foliage, which provided shelter to Robin Hood and his band of merry men and women.

The Major Oak grows ii
 new leaves in the i
-th year. It starts with 1
 leaf in year 1
.

Leaves last for k
 years on the tree. In other words, leaves grown in year i
 last between years i
 and i+k−1
 inclusive.

Robin considers even numbers lucky. Help Robin determine whether the Major Oak will have an even number of leaves in year n
.

Input
The first line of the input contains a single integer t
 (1≤t≤104
) — the number of test cases.

Each test case consists of two integers n
, k
 (1≤n≤109
, 1≤k≤n
) — the requested year and the number of years during which the leaves remain.

Output
For each test case, output one line, "YES" if in year n
 the Major Oak will have an even number of leaves and "NO" otherwise.

You can output the answer in any case (upper or lower). For example, the strings "yEs", "yes", "Yes", and "YES" will be recognized as positive responses.

Example
InputCopy
5
1 1
2 1
2 2
3 2
4 4
OutputCopy
NO
YES
NO
NO
YES
Note
In the first test case, there is only 1
 leaf.

In the second test case, k=1
, so in the 2
-nd year there will be 22=4
 leaves.

In the third test case, k=2
, so in the 2
-nd year there will be 1+22=5
 leaves.

In the fourth test case, k=2
, so in the 3
-rd year there will be 22+33=4+27=31
 leaves.

 */

package Contest;

import java.util.Scanner;

public class RobinHoodAndTheMajorOak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();  // Number of test cases

        while (t-- > 0) {
            long n = scanner.nextLong();  // Requested year
            long k = scanner.nextLong();  // Duration leaves last on the tree

            long startYear = Math.max(1, n - k + 1);

            // Check parity: sum of numbers from startYear to n
            // The sum is (n * (n + 1)) / 2 - (startYear - 1) * (startYear) / 2
            long totalLeaves = sumUpTo(n) - sumUpTo(startYear - 1);

            if (totalLeaves % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }

    // Helper method to calculate the sum of numbers from 1 to x
    static long sumUpTo(long x) {
        return x * (x + 1) / 2;
    }
}
