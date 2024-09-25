package Interview;
/*
Write a java program to print the path(position of the characters found in the matrix) of a given word in the matrix.
You are allowed to move only right & down in matrix at any cell.
Example matrix:
O R C R
A A H M
U C L E
Word: ORACLE
Ans: [[0,0], [0,1], [1, 1], [2, 1], [2, 2], [3, 3]]

 */
public class Test3 {
    private static char[][] matrix = { {'O', 'R', 'C', 'R'}, {'A', 'A', 'H', 'M'}, {'U', 'C', 'L', 'E'} };
    public static void main(String[] args){
        int r = matrix.length;
        int c = matrix[0].length;
        System.out.println(dfs("ORACLE", 0, 0,0));
    }
    static boolean dfs(String s , int index , int i , int j){
        if(index == s.length()){
            return true;
        }
        boolean ans = false;
        if(matrix[i+1][j] == s.charAt(index)){
            ans = dfs(s, index++, i++, j);
        }else if(matrix[i][j+1] == s.charAt(index)){
            ans = dfs(s, index++, i, j++);
        }else{
            return false;
        }
        return ans;
    }
}
