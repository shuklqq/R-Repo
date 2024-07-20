import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.add(str[0]);
        System.out.println("Stack 1 : " + stack);
        int count = 1;
        while(count < len){
            System.out.println("Stack 2 : " + stack + "Count : " + count);
            if(str[count] == ']'){
                System.out.println("Stack 3 : " + stack);
                char ch = stack.pop();
                StringBuilder s1 = new StringBuilder();
                while(ch != '[' ){
                    System.out.println("Stack 4 : " + stack);
                    s1.append(ch);
                    ch = stack.pop();
                }
                s1.reverse();
                StringBuilder st2 = new StringBuilder();
                while(!stack.empty() && (int)stack.peek() >= 48 && (int)stack.peek() <= 57){
                    ch = stack.pop();
                    System.out.println("ch : " + ch);
                    st2.append(ch);
                    System.out.println("ST2 : " + st2);

                }
                st2.reverse();
                System.out.println("ST2 : " + st2);
                int num = 0;
                for(int f = 0 ; f < st2.length(); f++){
                    num = (num * 10) + (int)st2.charAt(f) - 48;
                    System.out.println("Num1 : " + num);
                }
                System.out.println("Num : " + num);
                for(int b = 0 ; b < num ; b++){
                    System.out.println("S1 : " + s1.length());
                    for(int f = 0 ; f < s1.length(); f++){
                        stack.push(s1.charAt(f));
                     //   System.out.println("Stack 6 : " + stack);
                    }
                }
                count++;
            }else{
                stack.push(str[count]);
                count++;
            }
        }
        StringBuilder str1 = new StringBuilder();
        for(char ch : stack){
            str1.append(ch);
        }
        System.out.println("String : "+ str1);
        return str1.toString();
    }
}
