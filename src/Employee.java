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
    /** TODO Необходимо подумать и разработать метод сравнения. Вопрос: по каким критериям необходимо сравнивать?
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        Employee otherEmployee = (Employee) other;
        return lastName.equals(otherEmployee.lastName) &&
                firstName.equals(otherEmployee.firstName) &&
                patronymicName.equals(otherEmployee.patronymicName) &&
                department.equals(otherEmployee.department) &&
                salary = otherEmployee.salary;
    } */
    //hashCode
    public int hashCode() {
        return new Integer(id).hashCode()+ lastName.hashCode()+firstName.hashCode()+patronymicName.hashCode()+
                department.hashCode()+ new Double(salary).hashCode();
    }
    //увеличение зп
    public void increaseSalary (double percent) {
       salary += salary*percent/100;
    }

}
