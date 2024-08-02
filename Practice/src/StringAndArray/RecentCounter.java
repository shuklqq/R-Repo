package StringAndArray;

import java.util.ArrayList;

public class RecentCounter {
    private ArrayList<Integer> arr;
    private int counter;

    public RecentCounter() {
        arr = new ArrayList<>();
    }

    public int ping(int t) {
        counter = 0;
        arr.add(t);
        for (int a = 0; a < arr.size(); a++) {
            if (arr.get(a) >= (t - 3000) && (arr.get(a) <= (t))){
                counter++;
            }
        }
        return counter;
    }
}
