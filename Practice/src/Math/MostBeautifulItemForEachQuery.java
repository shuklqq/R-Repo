package Math;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*

You are given a 2D integer array items where items[i] = [pricei, beautyi] denotes the price and beauty of an item respectively.

You are also given a 0-indexed integer array queries. For each queries[j], you want to determine the maximum beauty of an item whose price is less than or equal to queries[j]. If no such item exists, then the answer to this query is 0.

Return an array answer of the same length as queries where answer[j] is the answer to the jth query.



Example 1:

Input: items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
Output: [2,4,5,5,6,6]
Explanation:
- For queries[0]=1, [1,2] is the only item which has price <= 1. Hence, the answer for this query is 2.
- For queries[1]=2, the items which can be considered are [1,2] and [2,4].
  The maximum beauty among them is 4.
- For queries[2]=3 and queries[3]=4, the items which can be considered are [1,2], [3,2], [2,4], and [3,5].
  The maximum beauty among them is 5.
- For queries[4]=5 and queries[5]=6, all items can be considered.
  Hence, the answer for them is the maximum beauty of all items, i.e., 6.
Example 2:

Input: items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]
Output: [4]
Explanation:
The price of every item is equal to 1, so we choose the item with the maximum beauty 4.
Note that multiple items can have the same price and/or beauty.
Example 3:

Input: items = [[10,1000]], queries = [5]
Output: [0]
Explanation:
No item has a price less than or equal to 5, so no item can be chosen.
Hence, the answer to the query is 0.


Constraints:

1 <= items.length, queries.length <= 105
items[i].length == 2
1 <= pricei, beautyi, queries[j] <= 109

 */
public class MostBeautifulItemForEachQuery {
    /*
    Approach 1 : Sorting and Binary search for faster lookup
    Complexity Analysis :
        Time Complexity : O((M+N) * log M)
        Space Complexity : O(log M)
     */
    /*
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });
        int max = items[0][1];
        for (int i = 1; i < items.length; i++) {
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }

        for (int i = 0; i < queries.length; i++) {
            // answer i-th query
            queries[i] = binarySearch(items, queries[i]);
        }

        return queries;
    }

    private int binarySearch(int[][] items, int targetPrice) {
        int l = 0;
        int r = items.length - 1;
        int maxBeauty = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (items[mid][0] > targetPrice) {
                r = mid - 1;
            } else {
                // Found viable price. Keep moving to right
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                l = mid + 1;
            }
        }
        return maxBeauty;
    }

     */
    /*
    Approach 2 : Storing the prices and respective max beauty in a TreeMap for sorting and faster lookup
    Complexity Analysis :
        Time Complexity : O((M + N) log N)
        Space Complexity : O(M)
     */
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        TreeMap<Integer, Integer> itemsMap = new TreeMap<>();
        int currMaxBeauty = 0;
        for (int[] item : items) {
            if (item[1] <= currMaxBeauty) {
                continue;
            }
            currMaxBeauty = item[1];
            itemsMap.put(item[0], currMaxBeauty);
        }

        for (int i = 0; i < queries.length; i++) {
            Map.Entry<Integer, Integer> mapEntry = itemsMap.floorEntry(queries[i]);
            if (mapEntry != null) {
                queries[i] = mapEntry.getValue();
            } else {
                queries[i] = 0;
            }
        }
        return queries;
    }
}
