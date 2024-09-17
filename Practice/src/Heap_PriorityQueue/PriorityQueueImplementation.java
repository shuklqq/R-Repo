/*

There are a number of students in a school who wait to be served. Two types of events, ENTER and SERVED, can take place which are described below.

ENTER: A student with some priority enters the queue to be served.
SERVED: The student with the highest priority is served (removed) from the queue.
A unique id is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):

The student having the highest Cumulative Grade Point Average (CGPA) is served first.
Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
Any students having the same CGPA and name will be served in ascending order of the id.
Create the following two classes:

The Student class should implement:
The constructor Student(int id, String name, double cgpa).
The method int getID() to return the id of the student.
The method String getName() to return the name of the student.
The method double getCGPA() to return the CGPA of the student.
The Priorities class should implement the method List<Student> getStudents(List<String> events) to process all the given events and return all the students yet to be served in the priority order.
Input Format

The first line contains an integer, , describing the total number of events. Each of the  subsequent lines will be of the following two forms:

ENTER name CGPA id: The student to be inserted into the priority queue.
SERVED: The highest priority student in the queue was served.
The locked stub code in the editor reads the input and tests the correctness of the Student and Priorities classes implementation.

 */

package Heap_PriorityQueue;

import java.util.*;

/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable<Student>{
    private int id;
    private String name;
    private double cgpa;
    Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getCGPA(){
        return cgpa;
    }
    @Override
    public int compareTo(Student o) {
        if(Double.compare(o.getCGPA(), this.getCGPA()) == 0){
            if(this.getName().compareTo(o.getName()) == 0){
                return Integer.compare(this.getID(), o.getID());
            }
            else{
                return this.getName().compareTo(o.getName());
            }
        }else{
            return Double.compare(o.getCGPA(), this.getCGPA());
        }
    }
}
class Priorities{
    public List<Student> getStudents(List<String> events){
        PriorityQueue<Student> arr = new PriorityQueue<>();
        int size = events.size();
        for(int a = 0 ; a < size ; a++){
            String[] s = events.get(a).split(" ");
            if("ENTER".equals(s[0])){
                String name = s[1];
                double cgpa = Double.parseDouble(s[2]);
                int id = Integer.parseInt(s[3]);
                arr.add(new Student(id,name,cgpa));
            }else if("SERVED".equals(s[0])){
                arr.poll();
            }
        }
        List<Student> students = new ArrayList<>();
        while (!arr.isEmpty()) {
            students.add(arr.poll());
        }

        return students;
    }
}


public class PriorityQueueImplementation {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
