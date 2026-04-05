import java.util.ArrayList;
import java.util.List;

public class PassByValueForCollection {
    public static void main(String[] args){
        List<Integer> apple = new ArrayList<>();
        apple.add(1);
        apple.add(5);
        apple.add(7);
        apple.add(8);
        increase(apple);
        System.out.println(apple);
    }
    private static void increase(List<Integer> apple){
        apple.add(22);
    }
}
