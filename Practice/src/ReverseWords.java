public class ReverseWords {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        if(str.length == 1){
            return str[0];
        }
        StringBuilder stringBuilder = new StringBuilder("");
        int i = (str.length - 1);
        while(i >= 0){
            stringBuilder.append(str[i]);
            if(i != 0){
                stringBuilder.append(" ");
            }
            i--;
        }
        return stringBuilder.toString();
    }
}
