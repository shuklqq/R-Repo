import java.util.HashMap;

public class TestApplication {
    public void InvokeMain(){
        String str = "I am am java java developer";
        String a[] = str.split("\\s+");
        HashMap<String, Integer> count = new HashMap<>();
        System.out.println( "here is the updated string ");
        for(int i = 0 ; i < a.length; i++){
            if(count.containsKey(a[i])) {
                int p = count.get(a[i]);
                p++;
                count.put(a[i],p);
             }
            else{
                count.put(a[i], 1);
            }
        }
        System.out.println(count);
    }
}
//I am am java java developer