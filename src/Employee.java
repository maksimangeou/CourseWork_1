import java.util.Objects;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String patronymicName;
    private int department;
    private double salary;
    private static int nextID = 1;

    public Employee(String lastName, String firstName, String patronymicName, int department, double salary) {
        this.id = nextID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.department = department;
        this.salary = salary;
        nextID++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public static int getNextID() {
        return nextID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void setNextID() {
        nextID++;
    }

    public static boolean isDepartmentTrue(int department) {
        return department <= 5 && department >= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && Double.compare(salary, employee.salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(patronymicName, employee.patronymicName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, patronymicName, department, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", patronymicName='" + patronymicName + '\'' +
               ", department=" + department +
               ", salary=" + salary +
               '}';
    }
}
