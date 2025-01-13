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
            employee[i-1] = new Employee("Фамилия_"+i,"Имя_"+i,"Отчество_"+
                    i,(r.nextInt(5)+1),r.nextInt(10)*1000+i*1000);
        }

        //меню выбора
        int choice; //переменная выбора меню
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==========================================");
            System.out.println("|             MENU SELECTION             |");
            System.out.println("==========================================");
            System.out.println("|   1. Вывести список сотрудников        |");
            System.out.println("|   2. Сумма затрат                      |");
            System.out.println("|   3. Минимальная ЗП                    |");
            System.out.println("|   4. Максимальная ЗП                   |");
            System.out.println("|   5. Средняя ЗП                        |");
            System.out.println("|   6. ФИО сотрудников                   |");
            System.out.println("|   7. Индексация ЗП                     |");
            System.out.println("|   8. Работа с отделами                 |");
            System.out.println("|   9. Завершение работы                 |");
            System.out.println("==========================================");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            EXTERNAL:
            switch (choice) {
                case 1:
                    System.out.println("==СПИСОК СОТРУДНИКОВ==");
                    getEmployee(employee);
                    break;
                case 2:
                    System.out.println("==СУММА ЗАТРАТ НА ЗАРПЛАТУ==");
                    System.out.println("Затраты на зарплату - "+getTotalSumSalary(employee));
                    break;
                case 3:
                    System.out.println("==МИНИМАЛЬНАЯ ЗАРПЛАТА==");
                    getMinSalary(employee);
                    break;
                case 4:
                    System.out.println("==МАКСИМАЛЬНАЯ ЗАРПЛАТА==");
                    getMaxSalary(employee);
                    break;
                case 5:
                    System.out.println("==СРЕДНЯЯ ЗАРПЛАТА==");
                    System.out.println("Средняя зарплата - "+getAvgSalary(employee));
                    break;
                case 6:
                    System.out.println("==ФИО ВСЕХ СОТРУДНИКОВ==");
                    getOnlyFIOName(employee);
                    break;
                case 7:
                    System.out.println("==ИНДЕКСАЦИЯ ЗП==");
                    System.out.print("Введите величину изменения зп (в %): ");
                    Scanner scn1 = new Scanner(System.in);
                    double percent = scn1.nextInt();
                    setIncreaseSalary(employee,percent);
                    break;
                case 8:
                    System.out.println("Введите номер отдела");
                    Scanner scanner1 = new Scanner(System.in);
                    int dep = scanner1.nextInt();
                    while (true) {
                        System.out.println("====================================================");
                        System.out.println("|                 MENU DEPARTMENT                  |");
                        System.out.println("====================================================");
                        System.out.println("|   1. Вывести список сотрудников по отделу        |");
                        System.out.println("|   2. Сумма затрат на ЗП по отделу                |");
                        System.out.println("|   3. Минимальная ЗП ПО ОТДЕЛУ                    |");
                        System.out.println("|   4. Максимальная ЗП ПО ОТДЕЛУ                   |");
                        System.out.println("|   5. Средняя ЗП ПО ОТДЕЛУ                        |");
                        System.out.println("|   6. Индексация ЗП ПО ОТДЕЛУ                     |");
                        System.out.println("|   7. Выход в главное меню                        |");
                        System.out.println("====================================================");
                        System.out.println("Enter your choice: ");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("==СПИСОК СОТРУДНИКОВ ПО ОТДЕЛУ==");
                                setEmployeeInDepart(employee,dep);
                                break;
                            case 2:
                                System.out.println("==СУММА ЗАТРАТ НА ЗАРПЛАТУ ПО ОТДЕЛУ==");
                                System.out.println("Затраты на зарплату в отделе"+dep+" - "+getTotalSumOfDepart(employee,dep));
                                break;
                            case 3:
                                System.out.println("==МИНИМАЛЬНАЯ ЗАРПЛАТА ПО ОТДЕЛУ==");
                                getMinSalaryOfDepart(employee,dep);
                                break;
                            case 4:
                                System.out.println("==МАКСИМАЛЬНАЯ ЗАРПЛАТА ПО ОТДЕЛУ==");
                                getMaxSalaryOfDepart(employee,dep);
                                break;
                            case 5:
                                System.out.println("==СРЕДНЯЯ ЗАРПЛАТА ПО ОТДЕЛУ==");
                                System.out.println("Средняя зарплата по отделу"+dep+" - "+getAvgSalaryInDepart(employee,dep));
                                break;
                            case 6:
                                System.out.println("==ИНДЕКСАЦИЯ ЗП==");
                                System.out.print("Введите величину изменения зп (в %) по отделу: ");
                                Scanner scn3 = new Scanner(System.in);
                                double percentInDep = scn3.nextInt();
                                setIncreaseSalaryInDepart(employee,dep,percentInDep);
                                break;
                            case 7:
                                break EXTERNAL;
                            default:
                                System.out.println("Введите корректное значения пункта меню");
                                break;
                        }

                    }
                case 9:
                    System.out.println("Работа завершена");
                    System.exit(0);
                default:
                    System.out.println("Введите корректное значения пункта меню");
                    break;

            }
        }
    }
    public static void getEmployee(Employee[] e) {
        for (Employee employee : e) {
            System.out.println(employee.toString());
        }
    }
    public static void getMinSalary(Employee[] e) {
        double minSalary = Integer.MAX_VALUE;
        for (Employee value : e) {
            if (minSalary > value.getSalary()) {
                minSalary = value.getSalary();
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
        double maxSalary = Integer.MIN_VALUE;
        for (Employee value : e) {
            if (maxSalary < value.getSalary()) {
                maxSalary = value.getSalary();
            }
        }
        for (Employee employee : e) {
            if (maxSalary == employee.getSalary()) {
                System.out.println("Сотрудник с максимальной зарплатой в " + maxSalary + " - " + employee.getLastName() + " " +
                        employee.getFirstName() + " " + employee.getPatronymicName());
            }
        }
    }
    public static double getTotalSumSalary(Employee[] e) {
        double totalSum =0.0;
        for (Employee employee : e) {
            totalSum += employee.getSalary();
        }
        return totalSum;
    }
    public static double getAvgSalary(Employee[] e) {
        double avgSal = getTotalSumSalary(e)/(Employee.getNextID()-1);
        return Math.ceil(avgSal*100)/100;
    }
    public static void getOnlyFIOName(Employee[] e) {
        String str;
        for(Employee employee: e) {
            str = employee.getLastName()+" "+employee.getFirstName()+" "+employee.getPatronymicName();
            System.out.println(str);
        }
    }
    public static void setIncreaseSalary(Employee[] e, double percent) {
        for(Employee employee: e) {
            double increase = employee.getSalary()*(100+percent)/100;
            employee.setSalary(increase);
        }
        getEmployee(e);
    }
    public static void getMinSalaryOfDepart(Employee[] e, int d) {
        double minSalary = Integer.MAX_VALUE;
        for (Employee value : e) {
            if (value.getDepartment() == d) {
                if (minSalary > value.getSalary()) {
                    minSalary = value.getSalary();
                }
            }
        }
        for (Employee employee : e) {
            if ((minSalary == employee.getSalary())&&(d == employee.getDepartment())) {
                System.out.println("Сотрудник с минимальной зарплатой в " + minSalary +
                        " в отделе "+employee.getDepartment()+" - " +
                        employee.getLastName() + " " +employee.getFirstName() + " " + employee.getPatronymicName());
            }
        }
    }
    public static void getMaxSalaryOfDepart(Employee[] e, int d) {
        double maxSalary = Integer.MIN_VALUE;
        for (Employee value : e) {
            if (value.getDepartment() == d) {
                if (maxSalary < value.getSalary()) {
                    maxSalary = value.getSalary();
                }
            }
        }
        for (Employee employee : e) {
            if ((maxSalary == employee.getSalary())&&(d == employee.getDepartment())) {
                System.out.println("Сотрудник с максимальной зарплатой в " + maxSalary +
                        " в отделе "+employee.getDepartment()+ " -  " + employee.getLastName() + " " +
                        employee.getFirstName() + " " + employee.getPatronymicName());
            }
        }
    }
    public static double getTotalSumOfDepart(Employee[] e, int d) {
        double totalSum = 0.0;
        for (Employee employee: e) {
            if (employee.getDepartment()==d) {
                totalSum += employee.getSalary();
            }
        }
        return totalSum;
    }
    public static double getAvgSalaryInDepart(Employee[] e, int d) {
        int i = 0;
        for(Employee employee:e) {
            if(employee.getDepartment()==d) i++;
        }
        double avgSal = getTotalSumOfDepart(e,d)/i;
        return Math.ceil(avgSal*100)/100;
    }
    public static void setIncreaseSalaryInDepart(Employee[] e, int d, double percent) {
        for (Employee employee : e) {
            if (employee.getDepartment() == d) {
                double increase = employee.getSalary() * (100 + percent) / 100;
                employee.setSalary(increase);
                System.out.println(employee);
            }
        }
    }
    public static void setEmployeeInDepart(Employee[] e, int d) {
        String str;
        for (Employee employee : e)
            if (employee.getDepartment() == d) {
                str = employee.getId() + " " +employee.getLastName() + " " + employee.getFirstName() + " " +
                        employee.getPatronymicName() + " " +employee.getSalary();
                System.out.println(str);
            }
    }
}