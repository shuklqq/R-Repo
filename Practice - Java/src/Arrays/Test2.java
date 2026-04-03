package Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ram", 100000, "IT"),
                new Employee(2, "Ravi", 20000, "Sales"),
                new Employee(3, "Rahul", 500000, "IT"),
                new Employee(4, "Rana", 450000, "Marketing"),
                new Employee(5, "Ranga", 30000, "Sales"));

        System.out.println("\nEmployees by department:");
        //TODO -Group Employees by department and print them using java8 streams
        Map<String, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee :: getDepartment));
        map.forEach((a, b) -> {
            b.forEach(c -> System.out.println(c.toString()));

        });

        Map<String,List<Employee>> temp = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        temp.forEach((a, b) -> {
            System.out.println("Department : " + a);
            b.stream().sorted((d,e) -> (int)e.getSal() - (int)d.getSal()).forEach(c -> System.out.println(c.toString()));
        });
        System.out.println("\nEmployees whose salary greater than 40000:");
        //TODO - Print employee name whose salary is greater than 40000 using java8 streams
        employees.stream().filter(emp -> emp.getSal() > 40000).forEach(emp -> System.out.println(emp.toString()));

        System.out.println("\nEmployees sorted by their name in descending order:");
        //TODO - Sort employees list by their name in descending order and print their names
        employees.stream().sorted((a , b) -> b.getName().compareTo(a.getName())).forEach(emp -> System.out.println(emp.getName()));

    }

    public static class Employee {
        private int id;
        private String name;
        private double sal;
        private String department;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSal() {
            return sal;
        }

        public void setSal(double sal) {
            this.sal = sal;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public Employee(int id, String name, double sal, String department) {
            this.id = id;
            this.name = name;
            this.sal = sal;
            this.department = department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", sal=" + sal +
                    ", department='" + department + '\'' +
                    '}';
        }
    }
}
