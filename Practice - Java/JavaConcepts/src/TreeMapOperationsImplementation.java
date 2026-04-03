import java.util.Map;
import java.util.TreeMap;

public class TreeMapOperationsImplementation {

    static TreeMap<Integer, String> tMap;

    public static void createMap(){
        tMap = new TreeMap<>();
        System.out.println("Treemap has been created.");
    }

    public static void InsertMap(){
        tMap.put(1,"aaa");
        tMap.put(3,"bbb");
        tMap.put(2,"ccc");
        System.out.println("Elements inserted :" + tMap);
    }

    public static void getByKey(Integer key){
        System.out.println("The value of the key: "+ key + " is " + tMap.containsKey(key));
    }

    public static void getByValue(String value){
        System.out.println("The key for the value "+ value + " is " + tMap.containsValue(value));
    }

    public static void Display(){
        System.out.println("Displaying the Tree Map "+ tMap);
    }

    public static void Traverse(){
        for(Map.Entry<Integer,String> e : tMap.entrySet()){
            System.out.println("Key : " + e.getKey() + "Value : " + e.getValue());
        }
    }

    public void invokeMain(){
        createMap();
        InsertMap();
        getByKey(2);
        getByValue("aaa");
        Display();
        Traverse();
    }
}
