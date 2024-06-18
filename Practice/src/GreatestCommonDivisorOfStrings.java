public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2){

        String replace;
        if(str1.length() > str2.length()){
            replace = str1;
            str1 = str2;
            str2 = replace;
        }
        int n = str1.length();
        while(n != 0){
            String str = "";
            if(str2.length() % n == 0){
                str = str1.substring(0, n);
            }
            String str3 = str1;
            String str4 = str2;
            str3 = str3.replaceAll(str.toString(), "");
            str4 = str4.replaceAll(str.toString(), "");
            if((str3.equals(""))&&(str4.equals(""))){
                return str.toString();
            }
            n--;
        }
        return"";
    }
}
