package StringAndArray;

import java.util.HashMap;
import java.util.Map;

public class ReverseVowels {
    public String reverseVowels(String s){
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder("");
        int j = chars.length -1;
        for(int i = 0; i < j ; i++){
            if(chars[i]=='a'||chars[i]=='e'||chars[i]=='i'||chars[i]=='o'||chars[i]=='u'||chars[i]=='A'||chars[i]=='E'||chars[i]=='I'||chars[i]=='O'||chars[i]=='U'){
                int mark = 0;
                while(j>i && mark == 0){
                    if(chars[j]=='a'||chars[j]=='e'||chars[j]=='i'||chars[j]=='o'||chars[j]=='u'||chars[j]=='A'||chars[j]=='E'||chars[j]=='I'||chars[j]=='O'||chars[j]=='U'){
                        char temp = chars[j];
                        chars[j] = chars[i];
                        chars[i] = temp;
                        mark++;
                    }
                    j--;
                }
            }
        }
        str.append(chars);
        return str.toString();
    }
}
