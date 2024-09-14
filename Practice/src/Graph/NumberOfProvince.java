/*

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.



Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3


Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]

 */

package Graph;
/*
Approach 1:
 */
//public class NumberOfProvince {
//    public int findCircleNum(int[][] isConnected) {
//        int count = 0;
//        boolean[] rowCheck = new boolean[isConnected.length];
//
//        for(int a  = 0 ; a < rowCheck.length ; a++){
//            if(!rowCheck[a]){
//                rowCheck = search(rowCheck, isConnected, a);
//                count++;
//            }
//        }
//
//        return count;
//    }
//    public boolean[] search(boolean[] rowCheck, int[][] isConnected, int row){
//        if(rowCheck[row]){
//            return rowCheck;
//        }else{
//            rowCheck[row] = true;
//        }
//
//        for(int a = 0 ; a < isConnected[row].length ; a++){
//            if(a != row){
//                if(isConnected[row][a] == 1){
//                    rowCheck = search(rowCheck, isConnected, a);
//                }
//            }
//        }
//
//        return rowCheck;
//    }
//}

/*
Approach 2 - Union
 */

class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union_set(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        } else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}

public class NumberOfProvince {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind dsu = new UnionFind(n);
        int numberOfComponents = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && dsu.find(i) != dsu.find(j)) {
                    numberOfComponents--;
                    dsu.union_set(i, j);
                }
            }
        }

        return numberOfComponents;
    }
}
