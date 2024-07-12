import java.util.HashMap;

public class EqualRowsAndColumnPairs2 {
    public int equalPairs(int[][] grid) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = grid.length;
        int count = 0;
        for (int[] ints : grid) {
            int hash = getRowHash(ints);
            mp.put(hash, mp.getOrDefault(hash, 0) + 1);
        }
        for(int i=0;i<n;i++){
            int hash = getColHash(grid,i);
            count+=mp.getOrDefault(hash,0);
        }
        return count;
    }
    private int getRowHash(int a[]){
        int hash = 0;
        for(int i=0;i<a.length;i++){
            hash = a[i] + (hash*7);
        }
        return hash;
    }
    private int getColHash(int a[][],int col) {
        int hash = 0;
        for (int i[] : a) {
            hash = i[col] + (hash * 7);
        }
        return hash;
    }
}
