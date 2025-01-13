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
    public Employee(String lName,String fName,String pName,int dep,double sal) {
        setId();
        setLastName(lName);
        setFirstName(fName);
        setPatronymicName(pName);
        setDepartment(dep);
        setSalary(sal);
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
        id = nextID;
        setNextID();
    }
    public void setLastName(String lName) {
        lastName = lName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }
    public void setDepartment(int department) {
        switch (department) {
            case 1, 3, 2, 4, 5: this.department = department; break;
            default: this.department = 0;
        }
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public static void setNextID() {
        nextID++;
    }
    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee e)) return false;

        if (id != e.id) return false;
        if (!Objects.equals(lastName, e.lastName)) return false;
        if (!Objects.equals(firstName, e.firstName)) return false;
        if (!Objects.equals(patronymicName, e.patronymicName)) return false;
        if (!Objects.equals(department, e.department)) return false;
        return salary == e.salary;
    }
    //hashCode
    @Override
    public int hashCode() {
        int i = id;
        i = 31*i+(lastName != null? lastName.hashCode():0);
        i = 31*i+(firstName != null? firstName.hashCode():0);
        i = 31*i+(patronymicName != null? patronymicName.hashCode():0);
        i = 31*i+(new Integer(department).hashCode());
        i = 31*i+(new Double(salary).hashCode());
        return i;
    }
    //toString
    @Override
    public String toString() {
        String str;
        str = id+" "+lastName+" "+firstName+" "+patronymicName+" "+department+" "+salary;
        return str;
    }
}
