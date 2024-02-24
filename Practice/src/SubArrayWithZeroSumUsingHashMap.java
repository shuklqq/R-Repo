import java.util.*;

public class SubArrayWithZeroSumUsingHashMap {

        static ArrayList<Pair> findSubArrays(int[] arr, int len){
            int sum = 0;
            ArrayList<Pair> out = new ArrayList<>();

            HashMap<Integer,ArrayList<Integer>> Sub = new HashMap<>();

            for(int i = 0; i < len; i++){
                sum+=arr[i];

                if(sum == 0){
                    out.add(new Pair(0,i));
                }
                ArrayList<Integer> al = new ArrayList<>();

                if(Sub.containsKey(sum)){
                    al = Sub.get(sum);
                    for (Integer integer : al) {
                        out.add(new Pair(integer + 1, i));
                    }
                }
                al.add(i);
                Sub.put(sum,al);
            }
            return out;
        }

        static void print(ArrayList<Pair> out){
            for (Pair a : out) {
                System.out.println("Subarray found from Indexes " + a.first + " to " + a.second);
            }
        }

        public static void InvokeStart() {
            int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
            int len = arr.length;

            ArrayList <Pair> out = findSubArrays(arr, len);

            if(out.isEmpty()){
                System.out.println("Sub Array does not exist");
            }else{
                print(out);
            }
        }
}
class Pair {
    int first, second;

    Pair(int a, int b) {
        first = a;
        second = b;
    }
}