package StringAndArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public void InvokeStart(){
        try{
            File myobj = new File("C:\\Users\\Ranjeet Kumar Shukla\\OneDrive\\Documents\\GitHub\\Files\\FileHandling.txt");
            myobj.createNewFile();
            FileWriter writer = new FileWriter("C:\\Users\\Ranjeet Kumar Shukla\\OneDrive\\Documents\\GitHub\\Files\\FileHandling.txt");
            writer.write("This is the test Line being written in a newly created file.");
            writer.close();
            System.out.println("Successfully written in a file");
        }catch(IOException e){
            System.out.println("Error occurred while Try Block Execution");
            e.printStackTrace();
        }
    }

    public void InvokeRead(){
        try{
            File myobj = new File("C:\\Users\\Ranjeet Kumar Shukla\\OneDrive\\Documents\\GitHub\\Files\\FileHandling.txt");
            Scanner reader = new Scanner(myobj);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                System.out.println(line);
            }
            if (myobj.exists()) {
                System.out.println("File name: " + myobj.getName());
                System.out.println("Absolute path: " + myobj.getAbsolutePath());
                System.out.println("Writeable: " + myobj.canWrite());
                System.out.println("Readable: " + myobj.canRead());
                System.out.println("File size in bytes: " + myobj.length());
            }
        }catch (FileNotFoundException f){
            System.out.println("File Not Found in the specified File Path. ");
            f.printStackTrace();
        }
    }
}
