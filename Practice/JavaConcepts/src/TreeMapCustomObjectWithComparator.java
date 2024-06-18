import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.TreeMap;

class Student{
    Integer id;
    String name;
    String address;

    Student(Integer id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public String toString(){
        return(this.id + " " + this.name + " " + this.address);
    }
}
class CompareStudent implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return(s1.id - s2.id);
    }
}
class TreeMapCustomObjectWithComparator{
    public void invokeMain(){
        TreeMap<Student, Integer> tMap= new TreeMap<Student, Integer>(new CompareStudent());

        tMap.put(new Student(101,"Sam", "India"), 2 );
        tMap.put(new Student(102,"Prateek", "Japan"), 1 );
        tMap.put(new Student(100,"Ranjeet", "America"), 3 );

        System.out.println("The Map is: "+ tMap);
    }
}
