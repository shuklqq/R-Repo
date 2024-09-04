package Graph;

public class NumberOfProvince {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] rowCheck = new boolean[isConnected.length];

        for(int a  = 0 ; a < rowCheck.length ; a++){
            if(!rowCheck[a]){
                rowCheck = search(rowCheck, isConnected, a);
                count++;
            }
        }

        return count;
    }
    public boolean[] search(boolean[] rowCheck, int[][] isConnected, int row){
        if(rowCheck[row]){
            return rowCheck;
        }else{
            rowCheck[row] = true;
        }

        for(int a = 0 ; a < isConnected[row].length ; a++){
            if(a != row){
                if(isConnected[row][a] == 1){
                    rowCheck = search(rowCheck, isConnected, a);
                }
            }
        }

        return rowCheck;
    }
}
