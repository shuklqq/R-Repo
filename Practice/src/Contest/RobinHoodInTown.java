package Contest;/*

Look around, the rich are getting richer, and the poor are getting poorer. We need to take from the rich and give to the poor. We need Robin Hood!

There are n
 people living in the town. Just now, the wealth of the i
-th person was ai
 gold. But guess what? The richest person has found an extra pot of gold!

More formally, find an aj=max(a1,a2,…,an)
, change aj
 to aj+x
, where x
 is a non-negative integer number of gold found in the pot. If there are multiple maxima, it can be any one of them.

A person is unhappy if their wealth is strictly less than half of the average wealth∗
.

If strictly more than half of the total population n
 are unhappy, Robin Hood will appear by popular demand.

Determine the minimum value of x
 for Robin Hood to appear, or output −1
 if it is impossible.

∗
The average wealth is defined as the total wealth divided by the total population n
, that is, ∑ain
, the result is a real number.

Input
The first line of input contains one integer t
 (1≤t≤104
) — the number of test cases.

The first line of each test case contains an integer n
 (1≤n≤2⋅105
) — the total population.

The second line of each test case contains n
 integers a1,a2,…,an
 (1≤ai≤106
) — the wealth of each person.

It is guaranteed that the sum of n
 across all test cases does not exceed 2⋅105
.

Output
For each test case, output one integer — the minimum number of gold that the richest person must find for Robin Hood to appear. If it is impossible, output −1
 instead.

Example
InputCopy
6
1
2
2
2 19
3
1 3 20
4
1 2 3 4
5
1 2 3 4 5
6
1 2 1 1 1 25
OutputCopy
-1
-1
0
15
16
0
Note
In the first test case, it is impossible for a single person to be unhappy.

In the second test case, there is always 1
 happy person (the richest).

In the third test case, no additional gold are required, so the answer is 0
.

In the fourth test case, after adding 15
 gold, the average wealth becomes 254
, and half of this average is 258
, resulting in 3
 people being unhappy.

In the fifth test case, after adding 16
 gold, the average wealth becomes 315
, resulting in 3
 people being unhappy.

 */

import java.util.Scanner;

public class RobinHoodInTown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int robinGold = 0;
            int peopleGivenGold = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] >= k) {
                    robinGold += a[i];
                } else if (a[i] == 0 && robinGold > 0) {
                    peopleGivenGold++;
                    robinGold--;
                }
            }

            System.out.println(peopleGivenGold);
        }

        scanner.close();
    }
}
