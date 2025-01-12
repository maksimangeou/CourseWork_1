import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Хранилище объектов "сотрудник". Индекс массива из командной строки
        System.out.print("Введите размер хранилища целочисленное значение: ");
        Scanner scn = new Scanner(System.in);
        int index = scn.nextInt();
        System.out.println();
        Employee[] employee = new Employee[index];
        //добавить произвольные данные сотрудников
        Random r = new Random();
        for (int i = 1; i<= employee.length;i++) {
            employee[i-1] = new Employee("Фамилия "+i,"Имя "+i,"Отчество "+
                    i,Integer.toString(r.nextInt(5)+1),r.nextInt(10)*1000+i*1000);
        }
        getEmployee(employee);
        getMinSalary(employee);
        getMaxSalary(employee);
        getAvgSalary(employee);
        for (Employee employee1: employee) {
            System.out.println(employee1.hashCode());
        }
    }
    public static void getEmployee(Employee[] e) {
        for (Employee employee : e) {
            System.out.println(employee.toString());
        }
    }
    public static void getMinSalary(Employee[] e) {
        System.out.println("==МИНИМАЛЬНАЯ ЗАРПЛАТА==");
        double minSalary = Integer.MAX_VALUE;
        for(int i=0; i<e.length;i++) {
            if(minSalary > e[i].getSalary()) {
                minSalary = e[i].getSalary();
            }
        }
        for (Employee employee : e) {
            if (minSalary == employee.getSalary()) {
                System.out.println("Сотрудник с минимальной зарплатой в " + minSalary + " - " + employee.getLastName() + " " +
                        employee.getFirstName() + " " + employee.getPatronymicName());
            }
        }
    }
    public static void getMaxSalary(Employee[] e) {
        System.out.println("==МАКСИМАЛЬНАЯ ЗАРПЛАТА==");
        double maxSalary = Integer.MIN_VALUE;
        for(int i=0; i<e.length;i++) {
            if(maxSalary < e[i].getSalary()) {
                maxSalary = e[i].getSalary();
            }
        }
        for (Employee employee : e) {
            if (maxSalary == employee.getSalary()) {
                System.out.println("Сотрудник с максимальной зарплатой в " + maxSalary + " - " + employee.getLastName() + " " +
                        employee.getFirstName() + " " + employee.getPatronymicName());
            }
        }
    }
    public static void getAvgSalary(Employee[] e) {
        System.out.println("==СРЕДНЯЯ ЗАРПЛАТА==");
        double avgSal =0.0;
        for (Employee employee : e) {
            avgSal += employee.getSalary();
        }
        avgSal /=e.length;
        System.out.println("Средняя зарплата - "+avgSal);
    }
}