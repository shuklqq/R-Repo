package LinkedList;

 class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(String name, int id, String department, double salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public int compareTo(Employee o) {
        if(salary > o.getSalary()){
            return 1;
        } else if (salary == o.getSalary()) {
            return 0;
        } else{
            return -1;
        }
    }
}
