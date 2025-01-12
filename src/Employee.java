public class Employee {
    //объявление переменных класса
    private String firstName;
    private String lastName;
    private String patronymicName;
    private String department;
    private double salary;
    private int id;
    //статическая переменная
    private static int nextID = 1;
    //конструктор
    public Employee(String lName,String fName,String pName,String dep,double sal) {
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
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    public int getId() {
        return id;
    }
    //статические методы
    public int getNextID() {
        return nextID;
    }
    //сеттеры
    public void setId() {
        id = nextID;
        nextID++;
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
    public void setDepartment(String department) {
        switch (department) {
            case "1", "3", "2", "4", "5": this.department = department; break;
            default: this.department = "без отдела";
        }
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;
        if (id != employee.id) return false;
        if (lastName != null ? !lastName.equals(employee.lastName): employee.lastName !=null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName): employee.firstName !=null) return false;
        if (patronymicName != null ? !patronymicName.equals(employee.patronymicName): employee.patronymicName !=null) return false;
        if (department != null ? !department.equals(employee.department): employee.department !=null) return false;
        return salary == employee.salary;
    }
    //hashCode
    @Override
    public int hashCode() {
        int i = id;
        i = 31*i+(lastName != null? lastName.hashCode():0);
        i = 31*i+(firstName != null? firstName.hashCode():0);
        i = 31*i+(patronymicName != null? patronymicName.hashCode():0);
        i = 31*i+(department != null? department.hashCode():0);
        i = 31*i+(new Double(salary).hashCode());
        return i;
    }
    //увеличение зп
    public void increaseSalary (double percent) {
       salary += salary*percent/100;
    }

}
