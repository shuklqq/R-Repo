package Graph;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        l1.add(3);
//        l1.add(2);
//
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(2);
//        l2.add(3);
//
//        List<Integer> l3 = new ArrayList<>();
//        l3.add(2);
//        l3.add(3);
//        l3.add(1);
//
//        List<Integer> l4 = new ArrayList<>();
//
//        list.add(l1);
//        list.add(l2);
//        list.add(l3);
//        list.add(l4);
//
//        KeysAndRooms k = new KeysAndRooms();
//        System.out.println(k.canVisitAllRooms(list));

// Minimum reorder to direct to zero
        int[][] rooms = {{0,2},{0,3},{4,1},{4,5},{5,0}};
        MinimumReorderToDirectToZero m = new MinimumReorderToDirectToZero();

        System.out.println(m.minReorder(6, rooms));

    }
}
