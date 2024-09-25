package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LambdaOnCollections {

    public void executeAll() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Scheduler");
        linkedList.add("Banana");
        linkedList.add("Carrot");
        linkedList.add("Diamond");
        linkedList.add("Elephant");
        linkedList.add("Football");

        linkedList.stream().forEach( a -> {
            StringBuilder s = new StringBuilder(a);
            s.append(" is gone");
            a = s.toString();
            System.out.println(a);
        });
        System.out.println(linkedList.get(1));

        ArrayList<Employee> empList = new ArrayList<>();
        for(int a = 0;  a < 10 ; a++){
            empList.add(new Employee("Sam " + a, a , "Department " + a , Math.random()));
        }

        Collections.sort(empList);

        for(Employee zx : empList){
            System.out.println(zx.getDepartment() + " " + zx.getSalary() + " " + zx.getName() + " " + zx.getId());
        }
    }

}
