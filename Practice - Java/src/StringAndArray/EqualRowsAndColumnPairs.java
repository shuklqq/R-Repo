package StringAndArray;

import java.util.ArrayList;

public class EqualRowsAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int count = 0;
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        for(int a = 0 ; a < grid[0].length ; a++){
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
            for(int b = 0; b < grid[0].length; b++){
                str1.append(grid[a][b]);
                str1.append('.');
                str2.append(grid[b][a]);
                str2.append('.');
            }
            System.out.println(str1.toString());
            System.out.println(str2.toString());
            s1.add(str1.toString());
            s2.add(str2.toString());
        }
        for(String s : s1){
            for(String x : s2){
                if(s.equals(x)){
                    count++;
                }
            }
        }
        return count;
    }
}
