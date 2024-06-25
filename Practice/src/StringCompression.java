public class StringCompression {
    public int compress(char[] chars) {
        StringBuilder str = new StringBuilder("");
        int count = 1;
        str.append(chars[0]);
        for(int a = 1 ; a < chars.length ; a++){
            if(chars[a] == chars[a-1]){
                count++;
            }else if(chars[a] != chars[a-1]) {
                if(count != 1){
                    str.append(count);
                }
                count = 1;
                str.append(chars[a]);
            }
            if(a == chars.length-1 && count != 1){
                str.append(count);
            }
        }
        System.out.println(str.toString());
 //       chars = str.toString().toCharArray();
        for(int a = 0 ; a < chars.length ; a++){
            if(a < str.length()){
                chars[a] = str.charAt(a);
                System.out.println(a + " " + str.charAt(a));
            }else{
                chars[a] = ' ';
            }

        }
        System.out.println(chars);
        return str.toString().length();
    }
}
