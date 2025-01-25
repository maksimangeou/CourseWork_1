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
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (!Objects.equals(lastName, employee.lastName)) return false;
        if (!Objects.equals(firstName, employee.firstName)) return false;
        if (!Objects.equals(patronymicName, employee.patronymicName)) return false;
        if (!Objects.equals(department, employee.department)) return false;
        return salary == employee.salary;
    }

    //hashCode
    @Override
    public int hashCode() {
        int i = id;
        i = 31 * i + (lastName != null ? lastName.hashCode() : 0);
        i = 31 * i + (firstName != null ? firstName.hashCode() : 0);
        i = 31 * i + (patronymicName != null ? patronymicName.hashCode() : 0);
        i = 31 * i + (Integer.valueOf(department).hashCode());
        i = 31 * i + (new Double(salary).hashCode());
        return i;
    }

    //toString
    @Override
    public String toString() {
        return id + " " + lastName + " " + firstName + " " + patronymicName + " " + department + " " + salary;
    }
}
