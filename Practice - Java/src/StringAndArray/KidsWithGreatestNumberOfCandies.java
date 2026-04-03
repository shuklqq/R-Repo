package StringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class KidsWithGreatestNumberOfCandies {
    public ArrayList<Boolean> kindsWithCandies(int[] candies, int extraCandies){
        ArrayList<Boolean> result = new ArrayList<Boolean>();
        int n = candies.length;
        int max = 0;
        for(int i = 0; i < n ; i++){
            if(candies[i]> max){
                max = candies[i];
            }
        }
        for(int i = 0; i < n ; i++){
            if(candies[i] + extraCandies > max){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}
