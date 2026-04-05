package DynamicProgramming;

import java.util.Arrays;

/*

Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.



Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.


Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1

 */
public class CountSquareSubMatricesWithAllOnes {
    /*\
    Approach 1 : Bottom Up Dynamic Programming: check each element [i][j] with [i-1][j], [i-1][j-1],[i][j-1] and assign
        the value in DP array accordingly for faster lookup.
    Complexity Analysis:
        Time Complexity : O(m*n)
        Space Complexity : O(m*n)
     */
   /* int[][] dp;
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        for(int a = 0 ; a < m ; a++){
            Arrays.fill(dp[a], -1);
        }

        int totalSquares = 0;
        for(int a = 0 ; a < m ; a++){
            for(int b = 0 ; b < n ; b++){
                if(matrix[a][b] != 0){
                    dp[a][b] = numberOfSquares(a, b, matrix);
                    totalSquares += dp[a][b];
                }else{
                    dp[a][b] = 0;
                }
            }
        }

        return totalSquares;
    }
    private int numberOfSquares(int row, int col, int[][] matrix){
        int min = 0;
        if(row > 0 && col > 0){
            if(dp[row - 1][col] != -1){
                min = dp[row-1][col];
            }
            if(dp[row - 1][col -1] != -1){
                min = Math.min(min, dp[row-1][col -1]);
            }
            if(dp[row][col -1] != -1){
                min = Math.min(min, dp[row][col -1]);
            }
        }else{
            return 1;
        }
        return min + 1;
    }

    */

    /*
    Approach 2 : Bottom - Up Dynamic Programming : more efficiently, to cover the edges created a dp array, with an
            extra row and column and all cells will be  by default set to 0.
    Complexity Analysis :
        Time Complexity : O(m*n)
        Space Complexity : O(m*n)

     */
    public int countSquares(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];

        int totalSquares = 0;
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                if (matrix[a][b] == 1) {
                    dp[a+1][b+1] = 1 + Math.min(dp[a+1][b], Math.min(dp[a][b], dp[a][b+1]));
                }
                totalSquares += dp[a+1][b+1];
            }
        }
        return totalSquares;
    }
}
