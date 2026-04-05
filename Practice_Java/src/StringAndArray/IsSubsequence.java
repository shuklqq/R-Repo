package StringAndArray;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int a = 0;
        int b = 0;
        while(a < t.length() && b < s.length()){
            if(s.charAt(b) == t.charAt(a)){
                b++;
            }
            a++;
        }
        return (b == s.length());
    }
}
