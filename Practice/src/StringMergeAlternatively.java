public class StringMergeAlternatively {
    public String mergeAlternately(String word1, String word2){
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        StringBuilder str = new StringBuilder("");
        int n;
        if(w1.length<w2.length){
            n = w2.length;
        }else{
            n = w1.length;
        }
        int i = 0;
        while(i < n){
            if(i < w1.length)
                str.append(w1[i]);

            if(i < w2.length)
                str.append(w2[i]);

            i++;
        }
        String s = str.toString();
        return s;
    }
}
