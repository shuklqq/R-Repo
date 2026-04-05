package Arrays;
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
import java.util.*;

public class FindMinTimeDifference {

    // Approach 1 : Converting time to integer minutes and comparing.
/*    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int a = 0 ; a < timePoints.size() ; a++){
            String[] s = timePoints.get(a).split(":");
            int adder = (Integer.parseInt(s[0])*60) + Integer.parseInt(s[1]);
            if(adder < 360){
                arr.add(adder  + 1440);
            }
            arr.add(adder);
        }
        arr.sort((a,b) -> b-a);
        int len = arr.size();
        int minValue = Integer.MAX_VALUE;
        for(int a = 0 ; a < len-1 ; a++){
            minValue = Math.min(minValue, (arr.get(a) - arr.get(a+1)));
        }
        return minValue;
    }

 */

    // Approach 2 : Same using Priority Queue
/*
        public int findMinDifference(List<String> timePoints) {
        PriorityQueue<Integer> arr = new PriorityQueue<>((a,b) -> b-a);
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
    // Approach 3 :

    public void setArr(int[] arr) {
        Arrays.sort(arr);
    }
}
