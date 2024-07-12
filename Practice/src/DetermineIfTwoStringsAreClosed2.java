import java.util.*;

public class DetermineIfTwoStringsAreClosed2 {
    public boolean closeStrings(String word1, String word2) {
        char[] n1 = word1.toCharArray();
        char[] n2 = word2.toCharArray();
        if(n1.length != n2.length){
            return false;
        }
        if(n1.length == 1 && n1[0] != n2[0]){
            return false;
        }
        Arrays.sort(n1);
        Arrays.sort(n2);
        System.out.println("After Sorting : " + Arrays.toString(n1) + "  || " + Arrays.toString(n2));
        if(Arrays.equals(n1, n2)){
            return true;
        }
        int x=0,y=0;
        while(x < n1.length && y < n2.length){
            System.out.println("1st : " + n1[x] + " x : " + x + " | " + n2[y] + " y : " + y);
            if(x == n1.length-1 && y == n2.length-1){
                break;
            }
            if(n1[x] == n2[y]){
                if(x < n1.length-1){
                    x++;
                }
                else{
                    y++;
                }
            }else{
                y++;
            }
            System.out.println("2nd : " + n1[x] + " x : " + x + " | " + n2[y] + " y : " + y);
        }
        System.out.println(x + " || " + y);
        if(x != y){
            return false;
        }
        ArrayList<Integer> arr1 = new ArrayList<>();
        int count = 1;
        for(int a  = 1 ; a < n1.length ; a++){
            if(n1[a] != n1[a-1]){
                arr1.add(count);
                count = 1;
            }else{
                count++;
            }
            if (a == n1.length-1){
                arr1.add(count);
            }
        }
        ArrayList<Integer> arr2 = new ArrayList<>();
        count = 1;
        for(int a  = 1 ; a < n2.length ; a++){
            if(n2[a] != n2[a-1]){
                arr2.add(count);
                count = 1;
            }else{
                count++;
            }
            if (a == n2.length-1){
                arr2.add(count);
            }
        }
        System.out.println("After ArrayList : " + arr1 + "  || " + arr2 );
        if(arr1.size() != arr2.size()){
            return false;
        }
        Collections.sort(arr1);
        Collections.sort(arr2);
        System.out.println("After Sorting " + arr1 + "  ||  " + arr2);
        return Objects.equals(arr1,arr2);
    }
}
