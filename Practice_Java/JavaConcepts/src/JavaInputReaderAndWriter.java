import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JavaInputReaderAndWriter {
    public static void main(String[] args){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Public\\Videos\\File.txt"));
            ArrayList<MyObject> objectList = new ArrayList<>(Arrays.asList
                            (new MyObject("Ranjeet", 25), new MyObject("Prateek", 26)));
            for(MyObject temp : objectList){
                writer.write(temp.toString() + "\n");
            }
            System.out.println("Closing the Writer object");
            writer.close();

            // reading the same objects and storing them in a new arraylist;

            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Public\\Videos\\File.txt"));
            ArrayList<MyObject> readerObjectList = new ArrayList<>();
            String line;
            String name = null;
            int age;
            while((line = reader.readLine()) != null){
                if(line.startsWith("Name : ")){
                    name = line.substring(7).trim();
                } else if (line.startsWith(" Age : ")) {
                    age = Integer.parseInt(line.substring(7).trim());
                    readerObjectList.add(new MyObject(name,age));
                }
            }
            for(MyObject temp : readerObjectList){
                System.out.println(temp.toString());
            }
            System.out.println("Closing the reader object");
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
record MyObject(String name, int age){
    @Override
    public String toString() {
        return "Name : " + name + " \n Age : " + age;
    }
}
