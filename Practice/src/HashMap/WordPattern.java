package HashMap;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String b[] = s.split(" ");
        char a[] = pattern.toCharArray();
        if(a.length != b.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap();
        int x = 0;
        while(x < a.length){
            if(map.containsKey(a[x])){
                if(!map.get(a[x]).equals(b[x])){
                    return false;
                }
            } else if (map.containsValue(b[x])) {
                return false;
            }else{
                map.put(a[x], b[x]);
            }
            x++;
        }
        return true;
    }
}
