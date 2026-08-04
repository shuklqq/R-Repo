package Arrays;

import java.util.LinkedList;
import java.util.List;

/*
You are given an integer array nums consisting of unique integers.

Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.

The smallest and largest integers of the original range are still present in nums.

Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.

 

Example 1:

Input: nums = [1,4,2,5]

Output: [3]

Explanation:

The smallest integer is 1 and the largest is 5, so the full range should be [1,2,3,4,5]. Among these, only 3 is missing.

Example 2:

Input: nums = [7,8,6,9]

Output: []

Explanation:

The smallest integer is 6 and the largest is 9, so the full range is [6,7,8,9]. All integers are already present, so no integer is missing.

Example 3:

Input: nums = [5,1]

Output: [2,3,4]

Explanation:

The smallest integer is 1 and the largest is 5, so the full range should be [1,2,3,4,5]. The missing integers are 2, 3, and 4.

 

Constraints:

2 <= nums.length <= 100
1 <= nums[i] <= 100
*/
public class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        int len = nums.length;
        boolean[] present  = new boolean[101];
        int max = 0;
        int min = 0;
        for(int i=0; i<len; i++){
            present[nums[i]] = true;
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        LinkedList<Integer> missingElements = new LinkedList<>();
        for(int i=min; i<=max; i++){
            if(!present[i]){
                missingElements.add(i);
            }
        }
        return missingElements;
    }   
    /*
    public List<Integer> findMissingElements(int[] nums) {
        long[] seen = new long[2];              // bit v of seen[v >> 6] marks value v as present
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int v : nums) {
            seen[v >> 6] |= 1L << v;            // shift distance is auto-masked to v & 63
            if (v < min) min = v;
            if (v > max) max = v;
        }

        // Values are unique, so the gap count is known up front: no missing -> no allocation,
        // otherwise the result list is sized exactly and never grows.
        int missingCount = (max - min + 1) - nums.length;
        if (missingCount == 0) return Collections.emptyList();
        List<Integer> missing = new ArrayList<>(missingCount);

        int firstWord = min >> 6, lastWord = max >> 6;
        for (int w = firstWord; w <= lastWord; w++) {
            long gaps = ~seen[w];                                   // absent values in this word
            if (w == firstWord) gaps &= -1L << min;                 // drop bits below min
            if (w == lastWord)  gaps &= -1L >>> (63 - (max & 63));  // drop bits above max
            while (gaps != 0) {
                missing.add((w << 6) + Long.numberOfTrailingZeros(gaps));
                gaps &= gaps - 1;                                   // clear lowest set bit
            }
        }
        return missing;                          // ascending by construction, no sort needed
    }
    */ 
}
