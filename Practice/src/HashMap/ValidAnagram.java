package HashMap;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
//        int a[] = new int[26];
//        for(int x = 0 ; x < s.length(); x++){
//            int i = (s.charAt(x)) - 97;
//            System.out.println("1 " + i + " "+ a[i]);
//            a[i]++;
//            System.out.println("2 " + i + " "+ a[i]);
//        }
//        for(int x = 0 ; x < t.length(); x++){
//            int i = (t.charAt(x)) - 97;
//            System.out.println("3 " + i + " "+ a[i]);
//            if(a[i] == 0){
//                return false;
//            }else{
//                a[i]--;
//                System.out.println("4 " + i + " "+ a[i]);
//            }
//        }
//        for(int x = 0 ; x < 26 ; x++){
//            if(a[x] != 0){
//                return false;
//            }
//        }
//        return true;

        char[] a = s.toCharArray();
        Arrays.sort(a);
        char[] b = t.toCharArray();
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
}
