package Test;

/*

Write most efficient java code for the following problem:
Given n processes that need to be executed. Among these n processes, k are classified as high-priority processes, with
their indices(1-based) represented in the array as high_priority[i].
An OS scheduler is responsible for overseeing the execution of all processes. when a scheduler assigns a set of
processes to a processor, it has two options:
1 - If the assigned processes are greater than 1 and even, it can divide the array of processes, denoted as p, into
two contiguous subarrays of equal length, p1 and p2, such that p = [p1,p2]. The scheduler will then allocate p1 to one
processor and p2 to another.
2 - Alternatively, the scheduler can choose to execute the assigned array of processes, p. The time required for process
 execution is determined based on the following criteria:
a - If the assigned processes do not include any high-priority processes, the scheduler will take normal_time seconds to
 complete all the assigned processes.
b - if there are high-priority processes among the assigned tasks(denoted as x), it will take (priority_time * x* l)
seconds to complete them, where l is the total number of assigned processes.

Total time required to execute all processes is the sum of the time taken by all processors for their assigned tasks.
 The task is to minimize the total execution time by optimizing the assignment of processes to processors with the
 operating system and return this minimum possible execution time.


Constrains:
1 <= n <= 10^9
n is a power of 2
1 <= k <= min(n,10^5)
1 <= high_priority[i] <= n
1 <= normal_time,priority_time <= 10^4

Take this example and optimize the code to get such solution:
n = 4
k = 1
normal_time = 2
priority_time = 2
high_priority = [1]

one of the optimal ways is as follows:
1 - Assign a processor to [1,2], which will execute the processes in (2*1*2) = 4 seconds.
2 - Assign a processor to [3,4], which will execute the processes in 2 seconds.

hence, total time taken is 6 seconds.

 */
import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class Scheduler {

    private static int normal_time;
    private static int priority_time;
    private static boolean[] isHighPriority;

    public static long getMinimumTime(int n, List<Integer> high_priority, int normalTime, int priorityTime) {
        normal_time = normalTime;
        priority_time = priorityTime;

        // Initialize the high priority array
        isHighPriority = new boolean[n + 1]; // 1-based indexing
        for (int process : high_priority) {
            isHighPriority[process] = true;
        }

        // Start the recursive function from 1 to n
        return calculateTime(1, n);
    }

    private static long calculateTime(int left, int right) {
        int length = right - left + 1;

        // Base case: if there is only one process
        if (length == 1) {
            return isHighPriority[left] ? priority_time : normal_time;
        }

        // Check if the current range contains any high-priority processes
        boolean containsHighPriority = false;
        for (int i = left; i <= right; i++) {
            if (isHighPriority[i]) {
                containsHighPriority = true;
                break;
            }
        }

        if (!containsHighPriority) {
            // If no high-priority processes, normal execution
            return normal_time;
        } else {
            // Recursive division and process
            int mid = (left + right) / 2;
            long leftTime = calculateTime(left, mid);
            long rightTime = calculateTime(mid + 1, right);

            // Time for executing the entire range directly
            long directExecutionTime = (long) priority_time * length * length;

            // Minimize the time between direct execution and dividing into two processors
            return Math.min(directExecutionTime, leftTime + rightTime);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int high_priorityCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> high_priority = IntStream.range(0, high_priorityCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int normal_time = Integer.parseInt(bufferedReader.readLine().trim());

        int priority_time = Integer.parseInt(bufferedReader.readLine().trim());

        long result = Scheduler.getMinimumTime(n, high_priority, normal_time, priority_time);

        System.out.println(result);

        bufferedReader.close();
    }
}