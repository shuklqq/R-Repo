package StringAndArray;

public class RemoveStarsFromAString {
    public String removeStars(String s) {
        char[] ch = s.toCharArray();
        int count = 0;
        StringBuilder str = new StringBuilder();
        for(char x : ch){
            if(x != '*'){
                str.append(x);
                count++;
            }else{
                str.deleteCharAt(count-1);
                count--;
            }
        }
        return str.toString();
    }
}
