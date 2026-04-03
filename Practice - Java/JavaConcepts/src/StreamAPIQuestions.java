
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee{
    private String name;
    private int salary;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String department;

    public Employee(String name, int salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name : " + this.name + " | Salary : " + this.salary;
    }
}
record Product(String name, String category, Double price){};

public class StreamAPIQuestions {
    public static void main(String[] args){


        List<String> names = Arrays.asList("Apple", "Banana", "Apricot", "Zebra", "Monkey", "Cat");
        List<Integer> numbers = Arrays.asList(1,24,62,3,76,34,51,98,22,56,11,5);
        List<Employee> employeeList = Arrays.asList(new Employee("Suraj",51000, "IT"),
                new Employee("Prateek", 60000, "Sales"),
                new Employee("Abhishek", 40000, "IT"),
                new Employee("Akshay", 35000, "Management"));
        List<Product> productList = Arrays.asList(new Product("Mouse", "Electronics", 2400.0),
                new Product("KeyBoard", "Electronics", 5700.0),
                new Product("Cup", "HouseHold", 400.0),
                new Product("Bag", "Personal", 3400.0));


        /*
             Question 1 : Write a Java program that takes a list of strings representing names and filters out names
             that start with the letter "A." Then, sort the remaining names in reverse alphabetical order and collect
             them into a list.
         */
        List<String> noneANames = names.stream()
                .filter(s -> !s.startsWith("A"))
                .sorted(Comparator.reverseOrder())
                .toList();
        /*
            Question 2 : Write a Java program that takes a list of integers, removes duplicates, keeps only
            even numbers, multiplies each remaining number by 2, and finally collects them into a list sorted in
            ascending order.
         */
        List<Integer> sortedDistinctEvenDoubles = numbers.stream()
                .distinct()
                .filter(number -> number%2==0)
                .map(number -> number*2)
                .sorted()
                .toList();

        /*
            Questions 3 : Given a list of Employee objects (each with name and salary attributes), write a Java program
            that finds the average salary of employees whose salary is above 50,000. Use the Streams API.
         */
        OptionalDouble avgSalary = employeeList.stream()
                .filter(employee -> employee.getSalary() > 50000)
                .mapToDouble(Employee::getSalary)
                .average();

        /*
            Question 4 : Given a list of Product objects (each with name, category, and price attributes),
            write a Java program that groups the products by their category and, for each category, finds the product
            with the highest price. Use the Streams API.
         */
        /*
            1 - If you prioritize performance and are certain about the uniqueness of keys, go for Collectors.toMap.
            2 - If you need more flexibility and plan to perform complex aggregations, Collectors.groupingBy is more
                appropriate.
         */
        Map<String, Product> maxPriceByCategory = productList.stream()
                .collect(Collectors.toMap(
                        Product::category,
                        Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Product::price))
                ));

        Map<String, Optional<Product>> maxPriceByCategory2 = productList.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.maxBy(Comparator.comparing(Product::price))
                ));

        /*
        Question 2:
            Given a list of String objects, write a program using Lambda Expressions and the Streams API to:
                Filter out strings whose lengths are less than 5.
                Convert the remaining strings to uppercase.
                Sort them alphabetically.
                Collect the result into a new list and print the list.
         */
        List<String> stringList = Arrays.asList("apple", "banana", "cat", "dog");
        List<String> newList = stringList.stream().filter(e -> e.length() >= 5).map(String::toUpperCase).sorted().toList();
        newList.forEach(System.out::println);

        /*
        Question 3:
            Given a list of employees where each employee has a name and department, write a program to:
                Group the employees by their departments using the Streams API.
                Print the names of employees grouped under each department.
                Use Lambda Expressions and avoid directly accessing the department field in a traditional way
                (use getDepartment() or similar methods).
         */
        List<Employee> employeeList2 = Arrays.asList(
                new Employee("Alisha", 70000000, "HR"),
                new Employee("Suraj",51000, "IT"),
                new Employee("Prateek", 60000, "Sales"),
                new Employee("Abhishek", 40000, "IT"),
                new Employee("Akshay", 35000, "Management"));
        Map<String, List<Employee>> employeeMap = employeeList2.stream().collect(
                Collectors.groupingBy(Employee::getDepartment));
        employeeMap.forEach((department, employees) -> {
            System.out.println("Department: " + department);
            employees.forEach(employee -> System.out.println("Employee Name : " + employee.getName()));
        });

        /*
        Question : There is a list of string, find the second-largest element in terms of length.
         */
        List<String> strings = Arrays.asList("Java","DotNet","C","C#","REACT-JS","ANGULAR");

        Optional<String> secondLargestString = strings.stream()
                .sorted((str1, str2) -> {
                    return str2.length() - str1.length();
                })
                .skip(1)
                .findFirst();
        secondLargestString.ifPresent(System.out::println);

        /*
        Question 4:
            Given a list of integers, write a program to:
                Partition the integers into two groups: one with numbers greater than 50 and the other with numbers
                less than or equal to 50.
                    Use the Streams API to create a Map<Boolean, List<Integer>> where:
                        true represents numbers greater than 50.
                        false represents numbers less than or equal to 50.
                    Print both groups.
         */
        List<Integer> numberList = Arrays.asList(1,67,23,46,89,56,54,32,78,91,12,50);
        Map<Boolean, List<Integer>> numberMap = numberList.stream().collect(Collectors.partitioningBy( e -> e > 50));
//        numberMap.entrySet().stream().forEach();
    }
}
