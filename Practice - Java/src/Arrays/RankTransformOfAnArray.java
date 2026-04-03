package Arrays;
/*

Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.


Example 1:

Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
Example 2:

Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.
Example 3:

Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]


Constraints:

0 <= arr.length <= 105
-109 <= arr[i] <= 109

 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        // Approach 1 : using priority queue to store indexes in the sorted format of Array,
        // Better for Space Complexity/
/*        if(arr.length == 0){
            return arr;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer Index1, Integer Index2){
                return Integer.compare(arr[Index1], arr[Index2]);
            }
        });
        int len = arr.length;
        for(int a = 0 ; a < len ; a++){
            heap.add(a);
        }
        int prev = arr[heap.peek()];
        int k = 1;
        arr[heap.poll()] = k;
        for(int a = 1 ; a < len ; a++){
            if(arr[heap.peek()] != prev){
                k++;
                prev = arr[heap.peek()];
            }
            arr[heap.poll()] = k;
        }
        return arr;

 */
        // Approach 2 : Using Hashmap for storing element and rank. Better for time complexity
        if(arr.length == 0){
            return arr;
        }
        int[] clone = arr.clone();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(clone);
        int rank = 1;
        for(int a = 0 ; a < clone.length ; a++){
            if(!map.containsKey(clone[a])){
                map.put(clone[a], rank++);
            }
        }
        for(int a = 0 ; a < arr.length ; a++){
            arr[a] = map.get(arr[a]);
        }
        return arr;
    }
    public static void main(String[] args){
        int[] arr = {37,12,28,9,100,56,80,5,12};
        RankTransformOfAnArray r = new RankTransformOfAnArray();
        int[] res = r.arrayRankTransform(arr);
        Arrays.stream(res).forEach(System.out::println);
    }
}
