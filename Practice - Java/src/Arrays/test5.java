package Arrays;

public class test5 {
    public static void main(String[] args){
        String[] strs = {"flower", "flow", "flight"}; // n
        StringBuilder str = new StringBuilder();
        Boolean prefixTrue = true;
        int prefixIndex = 0;
        while(prefixTrue == true){ // m = 4
            char ch = strs[0].charAt(prefixIndex);
            System.out.println("1");
            for(int a = 1 ; a < strs.length ; a++){ // n = 3
                System.out.println("2");
                if(strs[a].length() > prefixIndex){
                    System.out.println("3");
                    char temp = strs[a].charAt(prefixIndex); // m
                    if(temp != ch){
                        System.out.println("4");
                        prefixTrue = false;
                    }
                }else {
                    System.out.println("5");
                    prefixTrue = false;
                }
                System.out.println("6");
            }
            if(prefixTrue == true) {
                str.append(ch);
            }
            prefixIndex++;
        }
        System.out.println(str.toString());
    }
}
//time complexity - m*n
//