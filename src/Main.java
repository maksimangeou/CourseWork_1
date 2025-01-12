import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[10];

        /*employee[0] = new Employee("Задорожный","Максим","Петрович","1",150000.0);
        employee[1] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[2] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[3] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[4] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[5] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[6] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[7] = new Employee("Зад","Макс","Петр","6",150000.0);
        employee[8] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[9] = new Employee("Зад","Макс","Петр","2",15.0);*/
        Random r = new Random();
        for (int i = 1; i<=10;i++) {
            employee[i-1] = new Employee("Фамилия "+i,"Имя "+i,"Отчество "+
                    i,Integer.toString(r.nextInt(5)),r.nextInt(10)*1000+i*1000);
        }
        getEmployee(employee);
        getMinSalary(employee);
        getMaxSalary(employee);
    }
    public static void getEmployee (Employee[] e) {
        for (int i=0; i<10;i++) {
            System.out.println(e[i].getId() + " " +
                    e[i].getLastName() + " " +
                    e[i].getFirstName() + " " +
                    e[i].getPatronymicName() + " " +
                    e[i].getDepartment() + " " + e[i].getSalary()
            );
        }
    }
    public static void getMinSalary(Employee[] e) {
        System.out.println("==МИНИМАЛЬНАЯ ЗАРПЛАТА==");
        double minSalary;
        minSalary = e[0].getSalary();
        for(int i=1; i<10;i++) {
            if(minSalary > e[i].getSalary()) {
                minSalary = e[i].getSalary();
            }
        }
        for(int i=0; i<10;i++) {
            if (minSalary==e[i].getSalary()) {
                System.out.println("Сотрудник с минимальной зарплатой в "+ minSalary+ " - "+e[i].getLastName()+" "+
                        e[i].getFirstName()+" "+e[i].getPatronymicName());
            }
        }
    }
    public static void getMaxSalary(Employee[] e) {
        System.out.println("==МАКСИМАЛЬНАЯ ЗАРПЛАТА==");
        double maxSalary;
        maxSalary = e[0].getSalary();
        for(int i=1; i<10;i++) {
            if(maxSalary < e[i].getSalary()) {
                maxSalary = e[i].getSalary();
            }
        }
        for (int i=0; i<10;i++) {
            if (maxSalary == e[i].getSalary()) {
                System.out.println("Сотрудник с максимальной зарплатой в " + maxSalary + " - " + e[i].getLastName() + " " +
                        e[i].getFirstName() + " " + e[i].getPatronymicName());
            }
        }
    }
}