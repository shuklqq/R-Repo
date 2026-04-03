package StringAndArray;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int max = gain[0], sum = gain[0];
        int a = 1;
        while(a < gain.length){
            sum = sum + gain[a];
            a++;
            max = Math.max(max,sum);
            System.out.println("Max : " + max + "|| Sum : " + sum);
        }
        return max < 0 ? 0 : max;
    }
}
