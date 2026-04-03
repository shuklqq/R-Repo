package TwoPointer;

public class Practice {
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
            ans = dfs(s, ++index, ++i, j);
        }else if(matrix[i][j+1] == s.charAt(index)){
            ans = dfs(s, ++index, i, ++j);
        }else{
            return false;
        }
        return ans;
    }
}
