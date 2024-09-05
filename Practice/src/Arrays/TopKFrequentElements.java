/*

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size

 */

package Arrays;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

// Approach 1

//        Map<Integer, Integer> memo = new HashMap<>();
//        int[] res = new int[k];
//        for(int a : nums){
//            memo.putIfAbsent(a, 0);
//            int c = memo.get(a);
//            memo.put(a, c+1);
//        }
//        List<Map.Entry<Integer, Integer>> temp = new ArrayList<Map.Entry<Integer, Integer>>(memo.entrySet());
//        Collections.sort(temp, new Comparator<Map.Entry<Integer,Integer>>(){
//            public int compare( Map.Entry<Integer, Integer> l1, Map.Entry<Integer, Integer> l2){
//                return l2.getValue().compareTo(l1.getValue());
//            }
//        });
//        int flag = 0;
//        for(Map.Entry<Integer, Integer> entry : temp){
//            if(flag == k){
//                break;
//            }
//            res[flag] = entry.getKey();
//            flag++;
//
//        }
//        return res;
/*
 Approach 2 - Here we created a priority queue in order to optimize the time complexity - the priority queue defined
 compares the inserted value with existing and push the minimum value on the top of the queue. Helping in keeping on K
 elements in the priority queue.
*/
//        Map<Integer, Integer> memo = new HashMap<>();
//        for(int num : nums){
//            memo.put(num, memo.getOrDefault(num, 0) + 1);
//        }
//        Queue<Integer> heap = new PriorityQueue<>(
//                (n1, n2) -> memo.get(n1) - memo.get(n2)
//        );
//        for(int num : memo.keySet()){
//            heap.add(num);
//            if(heap.size() > k){
//                heap.poll();
//            }
//        }
//        int[] res = new int[k];
//        for(int i = k - 1 ; i >= 0; i--){
//            res[i] = heap.poll();
//        }
//        return res;

/*
 Approach 3 - The only major time consuming factor remaining is Comparing while inserting in the priority queue. This is
 can be reduces via bucket sorting reducing the time complexity even more.
 */

        if (k == nums.length) return nums;
        Map<Integer, Integer> memo = new HashMap<>();
        for (int num : nums) {
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int key : memo.keySet()) {
            buckets[memo.get(key)].add(key);
        }
        List<Integer> flattened = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int num : buckets[i]) {
                flattened.add(num);
            }
        }
        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = flattened.get(i);
        }
        return top;
    }
}
