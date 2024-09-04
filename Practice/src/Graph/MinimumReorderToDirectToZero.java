package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumReorderToDirectToZero {
//    public int minReorder(int n, int[][] connections) {
//        List<Integer> arr = new ArrayList<>();
//        int count = 0, leftIndex, rightIndex = 0;
//        while(connections[rightIndex][0] != 0 && connections[rightIndex][1] != 0){
//            rightIndex++;
//        }
//        if(connections[rightIndex][0] == 0){
//            count++;
//        }
//        arr.add(connections[rightIndex][0]);
//        arr.add(connections[rightIndex][1]);
//
//        leftIndex = rightIndex - 1;
//        rightIndex++;
//
//        if(rightIndex < connections.length - 1){
//            while(rightIndex < connections.length){
//                int first = connections[rightIndex][0];
//                int second = connections[rightIndex][1];
//                if (arr.contains(second) && (!arr.contains(first))) {
//                    arr.add(first);
//                } else if (arr.contains(first) && (!arr.contains(second))) {
//                    arr.add(second);
//                    count++;
//                }
//                rightIndex++;
//            }
//        }
//        if(leftIndex >= 0){
//            while(leftIndex >= 0){
//                int first = connections[leftIndex][0];
//                int second = connections[leftIndex][1];
//                if (arr.contains(second) && (!arr.contains(first))) {
//                    arr.add(first);
//                } else if (arr.contains(first) && (!arr.contains(second))) {
//                    arr.add(second);
//                    count++;
//                }
//                leftIndex--;
//            }
//        }
//
//        return count;
//    }

// Second Solution
//        Stack<Integer> arr = new Stack<>();
//
//        int count = 0;
//        arr.push(0);
//        while(!arr.empty()){
//            int curr = arr.pop();
//            for(int a = 0 ; a < connections.length ; a++){
//                if(connections[a][0] == -1){
//                    continue;
//                }
//                if(connections[a][0] == curr || connections[a][1] == curr){
//                    if(connections[a][0] == curr){
//                        count++;
//                        arr.push(connections[a][1]);
//                    }else{
//                        arr.push(connections[a][0]);
//                    }
//                    connections[a][0] = -1;
//                    connections[a][1] = -1;
//                }
//            }
//        }
//        return count;
//    }


// Third Solution
    public int count = 0;
    boolean[] reachable;

    public int minReorder(int n, int[][] connections) {
        reachable = new boolean[connections.length + 1];
        reachable[0] = true;

        for (int i = 0; i < n; i++) {
            compute(i, connections);
        }
        return count;

    }

    public void compute(int currentEdge, int[][] connections) {
        if (currentEdge >= connections.length)
            return;
        int u = connections[currentEdge][0];
        int v = connections[currentEdge][1];
        if (reachable[v]) {
            reachable[u] = true;
            return;
        }
        if (reachable[u]) {
            count++;
            reachable[v] = true;
        } else {
            compute(currentEdge + 1, connections);
            if (reachable[v]) {
                reachable[u] = true;
                return;
            }
            if (reachable[u]) {
                count++;
                reachable[v] = true;
            }
        }
    }
}
