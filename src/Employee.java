import java.util.Objects;

public class Employee {
    //объявление переменных класса
    private String firstName;
    private String lastName;
    private String patronymicName;
    private int department;
    private double salary;
    private int id;
    //статическая переменная
    private static int nextID = 1;

    //конструктор
    public Employee(String lastName, String firstName, String patronymicName, int department, double salary) {
        setId();
        setLastName(lastName);
        setFirstName(firstName);
        setPatronymicName(patronymicName);
        setDepartment(department);
        setSalary(salary);
    }

    //геттеры
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

    public int getId() {
        return id;
    }

    public static int getNextID() {
        return nextID;
    }

    //сеттеры
    public void setId() {
        id = getNextID();
        setNextID();
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

    //метод проверки корректности ввода номера отдела
    public static boolean isDepartmentTrue(int department) {
        return department <= 5 && department >= 1;
    }

    //equals


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department &&
                Double.compare(salary, employee.salary) == 0 &&
                id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(patronymicName, employee.patronymicName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymicName, department, salary, id);
    }

    //toString
    @Override
    public String toString() {
        return id + " " + lastName + " " + firstName + " " + patronymicName + " " + department + " " + salary;
    }
}
