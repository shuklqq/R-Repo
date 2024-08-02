package StringAndArray;

import java.util.Stack;

public class AstroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length == 1 || asteroids.length == 0){
            return asteroids;
        }
        Stack<Integer> s = new Stack<Integer>();
        s.push(asteroids[0]);


        for(int a = 1 ; a < asteroids.length ; a++){
            s.push(asteroids[a]);
            int check = 0;
            while(check == 0){
                if(s.size() < 2){
                    break;
                }
                int y = (int) s.pop();
                int x = (int) s.pop();
                System.out.println("x : " + x + " y : " + y);
                if(x > 0 && y < 0) {
                    int j = x + y;
                    System.out.println("j1 : " + j);
                    if (j < 0) {
                        s.push(y);
                    } else if (j > 0) {
                        s.push(x);
                    }
                    System.out.println("s1 : " + s);
                }
                else{
                    s.push(x);
                    s.push(y);
                    check = 1;
                    System.out.println("s3 : " + s);
                }
            }
        }
        int size = s.size();
        int[] result = new int[size];
        for(int a = size-1 ; a >= 0  ; a--){
            result[a] = (int) s.pop();
        }
        return result;
    }
}
