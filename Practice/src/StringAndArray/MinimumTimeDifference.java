package StringAndArray;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*

Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.


Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1
Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0


Constraints:

2 <= timePoints.length <= 2 * 104
timePoints[i] is in the format "HH:MM".

 */
public class MinimumTimeDifference {
    /*
    Approach 1 : Using Priority Queue for sorting and storing duplicates for values in first 12 hours to
                cover the minute difference calculation.
    Complexity Analysis :
        Time Complexity: O( n* logn )
        Space Complexity : O( n )
     */
    /*public int findMinDifference(List<String> timePoints) {
        PriorityQueue<Integer> arr = new PriorityQueue<>((a, b) -> b-a);
        for(int a = 0 ; a < timePoints.size() ; a++){
            String[] s = timePoints.get(a).split(":");
            int adder = (Integer.parseInt(s[0])*60) + Integer.parseInt(s[1]);
            if(adder < 360){
                arr.add(adder  + 1440);
            }
            arr.add(adder);
        }
        int len = arr.size();
        int minValue = Integer.MAX_VALUE;
        for(int a = 0 ; a < len-1 ; a++){
            minValue = Math.min(minValue, (arr.poll() - arr.peek()));
        }
        return minValue;
    }

     */
    /*
    Approach 2 : Using an array as a timepoints with duplicates for first 12 hours of the day. And then
                sorting and doing a minimum difference lookup.
    Complexity Analysis :
        Time Complexity : O(n * logn)
        Space Complexity : O(n)
     */
    /*public int findMinDifference(List<String> timePoints) {
        int size1 = 2 * timePoints.size();
        int[] arr1 = new int[size1];
        int size = 0;
        for (int a = 0; a < timePoints.size(); a++) {
            String time = timePoints.get(a);
            int adder = ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            if (adder < 360) {
                arr1[size++] = adder + 1440;
            }
            arr1[size++] = adder;
        }
        Arrays.sort(arr1);
        int minValue = Integer.MAX_VALUE;
        for (int a = size1 - 1; a > size1 - size; a--) {
            minValue = Math.min(minValue, arr1[a] - arr1[a - 1]);
        }
        return minValue;
    }

     */
    /*
    Approach 3 : Using a boolean array storing the minutes in the timepoints list and then finding the
                minimum difference.
    Complexity Analysis:
        Time Complexity : O(n)
        Space Complexity : O(n)
     */
    public int findMinDifference(List<String> timePoints) {
        boolean[] bucket = new boolean[24 * 60];
        for (String time : timePoints) {
            int mins = ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 + (time.charAt(3) - '0') * 10
                    + (time.charAt(4) - '0');
            if (bucket[mins])
                return 0;
            bucket[mins] = true;
        }

        int pre = 0;
        int mini = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i]) {
                if (first != Integer.MAX_VALUE) {

                    mini = Math.min(i - pre, mini);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                pre = i;
            }
        }
        mini = Math.min(mini, (24 * 60 - last + first));
        return mini;
    }
}
