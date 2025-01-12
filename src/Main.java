import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        //добавить произвольные данные сотрудников
        Random r = new Random();
        for (int i = 1; i<=10;i++) {
            employee[i-1] = new Employee("Фамилия "+i,"Имя "+i,"Отчество "+
                    i,Integer.toString(r.nextInt(5)),r.nextInt(10)*1000+i*1000);
        }
        getEmployee(employee);
        getMinSalary(employee);
        getMaxSalary(employee);
        getAvgSalary(employee);
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
    public static void getAvgSalary(Employee[] e) {
        System.out.println("==СРЕДНЯЯ ЗАРПЛАТА==");
        double avgSal =0.0;
        for(int i=0; i<10;i++) {
            avgSal += e[i].getSalary();
        }
        avgSal /=10;
        System.out.println("Средняя зарплата - "+avgSal);
    }
}