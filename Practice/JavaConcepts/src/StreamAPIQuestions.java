
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee{
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
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
        List<Employee> employeeList = Arrays.asList(new Employee("Suraj",51000),
                new Employee("Prateek", 60000),
                new Employee("Abhishek", 40000),
                new Employee("Akshay", 35000));
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
    }
}
