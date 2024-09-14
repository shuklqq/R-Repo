/*

n this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.



Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]


Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected.

 */

/*
Approach 1 - Union Approach
 */

package Graph;

class Union{
    int[] parent;
    int[] rank;
    Union(int b){
        parent = new int[b+1];
        for(int i = 0 ; i < b+1 ; i++){
            parent[i] = i;
        }
        rank = new int[b+1];
    }
    public int find(int x){
        if(parent[x] != x){
            return find(parent[x]);
        }
        return x;
    }
    public void unionCreation(int x , int y){
        int xSet = find(x); int ySet = find(y);
        if(xSet == ySet){
            return;
        }else if(rank[xSet] < rank[ySet]){
            parent[ySet] = xSet;
        }else if(rank[ySet] < rank[xSet]){
            parent[xSet] = ySet;
        }else{
            parent[ySet] = xSet;
            rank[ySet]++;
        }
    }
}
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        Union node = new Union(size);
        int[] result = new int[2];
        for(int a = 0 ; a < size ; a++){
            int x = edges[a][0];
            int y = edges[a][1];
            if(node.find(x) != node.find(y)){
                node.unionCreation(x,y);
            }else{
                result[0] = x;
                result[1] = y;
                break;
            }
        }
        return result;
    }
}
