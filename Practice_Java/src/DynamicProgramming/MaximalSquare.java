/**
 * 
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * 
 * Example 2:
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * 
 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 *
 *  Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 * 
 */

public class MaximalSquare{
    public static void main(String args[]){
        char matrix[][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new Solution().maximalSquare(matrix));
    }
}
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        int max = 0;
        for(int a = 0 ; a < m ; a++){
            if(matrix[a][0] == '0'){
                dp[a][0] = 0;
            }
            else{
                dp[a][0] = 1;
                max = 1;
            }
        }
        for(int a = 0 ; a < n ; a++){
            if(matrix[0][a] == '0'){
                dp[0][a] = 0;
            }
            else{
                dp[0][a] = 1;
                max = 1;
            }
        }
        for(int a = 1; a < m ; a++){
            for(int b = 1 ; b < n ; b++){
                if(matrix[a][b] == '0'){
                    dp[a][b] = 0;
                }else{
                    dp[a][b] = Math.min(Math.min(dp[a-1][b], dp[a-1][b-1]), dp[a][b-1]) + 1;
                    max = Math.max(dp[a][b], max);
                }
            }
        }
        return max*max;
    }
}