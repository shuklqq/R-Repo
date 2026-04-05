package StringAndArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> n1 = new HashMap<>();
        for(int b : arr){
            if(n1.containsKey(b)){
                int a = n1.get(b);
                a++;
                n1.put(b,a);
            }else{
                n1.put(b,1);
            }
            System.out.println("b : " + b + " : value : " + n1.get(b));
        }

        ArrayList<Integer> n2 = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : n1.entrySet()) {
            int a1 = (int)integerIntegerEntry.getValue();
            if(n2.contains(a1)){
                return false;
            }
            else{
                n2.add(a1);
            }
        }
        return true;
    }
}
