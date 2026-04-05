package Heap_PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*

You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks.



Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B.
In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2
intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice
between repetitions of these tasks.



Constraints:

1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100

 */
public class taskScheduler {
    /*
    Approach 1 : Using priority queue to manage the greedy approach of taking maximum frequency task and using loop to
                take care of the n interval difference that is needed to be taken care.
    Complexity Analysis :
        Time complexity: O(N) : In the worst case, all tasks must be processed, and each task might be inserted and
                                extracted from the priority queue. The priority queue operations (insertion and
                                extraction) have a time complexity of O(logk) each. Therefore, the overall time
                                complexity is O(N⋅logk). Since k is at maximum 26, logk is a constant term. We can
                                simplify the time complexity to O(N). This is a linear time complexity with a high
                                constant factor.
        Space complexity: O(26) = O(1) : The space complexity is mainly determined by the frequency array and the
                                priority queue. The frequency array has a constant size of 26, and the priority
                                queue can have a maximum size of 26 when all distinct tasks are present. Therefore,
                                the overall space complexity is O(1) or O(26), which is considered constant.
     */
    /*
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int b : freq){
            if(b > 0){
                pq.offer(b);
            }
        }
        int time = 0;
        while(!pq.isEmpty()){
            int cycle = n+1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            while(cycle-- > 0 && !pq.isEmpty()){
                int currentFreq = pq.poll();
                if(currentFreq > 1){
                    store.add(currentFreq - 1);
                }
                taskCount++;
            }
            store.forEach(pq::offer);
            time += (pq.isEmpty() ? taskCount : n+1);
        }
        return time;
    }

     */
    /*
    Approach 2 : Using greedy approach to calculate the number of intervals that would be needed.
    Complexity Analysis :
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ ch - 'A']++;
        }
        int maxFreq = 0, countOfMaxFreq = 0;
        for(int a : freq){
            if(a > maxFreq){
                maxFreq = a;
                countOfMaxFreq = 1;
            }else if(a == maxFreq){
                countOfMaxFreq++;
            }
        }
        return Math.max((((maxFreq-1)*(n+1))+countOfMaxFreq), tasks.length);
    }
}
