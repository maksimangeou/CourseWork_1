import java.util.Scanner;

public class EmployeeBook {
    private static Employee[] employee;
    private static int index = 0;
    private static final String MAIN_MENU = """
            =============================================
            |              MENU SELECTION               |
            =============================================
            |   1. Вывести список сотрудников           |
            |   2. Добавить сотрудника в список         |
            |   3. Удалить сотрудника из списка         |
            |   4. Поиск специалиста по id              |
            |   5. Сумма затрат по ЗП                   |
            |   6. Минимальная ЗП                       |
            |   7. Максимальная ЗП                      |
            |   8. Средняя ЗП                           |
            |   9. ФИО сотрудников                      |
            |   10. Индексация ЗП                       |
            |   11. Работа с отделами                   |
            |   12. Поиск специалистов с ЗП менее числа |
            |   13. Поиск специалистов с ЗП более числа |
            |   14. Завершение работы                   |
            =============================================
            Введите номер пункта меню:\s""";

    private static final String DEPARTMENT_MENU = """
            ====================================================
            |                 MENU DEPARTMENT                  |
            ====================================================
            |   1. Вывести список сотрудников по отделу        |
            |   2. Сумма затрат на ЗП по отделу                |
            |   3. Минимальная ЗП ПО ОТДЕЛУ                    |
            |   4. Максимальная ЗП ПО ОТДЕЛУ                   |
            |   5. Средняя ЗП ПО ОТДЕЛУ                        |
            |   6. Индексация ЗП ПО ОТДЕЛУ                     |
            |   7. Выход в главное меню                        |
            ====================================================
            Введите номер пункта меню:\s""";

    public void manageMenu() {
        Scanner scanChoice = new Scanner(System.in);
        Scanner scanPause = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println(MAIN_MENU);
            choice = scanChoice.nextInt();
            EXTERNAL:
            switch (choice) {
                case 1:
                    System.out.println("==СПИСОК СОТРУДНИКОВ==");
                    getEmployee();
                    System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                    scanPause.nextLine();
                    break;
                case 2:
                    System.out.println("==ДОБАВИТЬ СОТРУДНИКА В СПИСОК==");
                    enterEmployeeDataInMenu();
                    scanPause.nextLine();
                    break;
                case 3:
                    System.out.println("""
                            ==УДАЛИТЬ СОТРУДНИКА ИЗ СПИСКА==
                            Введите id сотрудника для удаления:\s""");
                    Scanner scn1 = new Scanner(System.in);
                    int idRemove = scn1.nextInt();
                    if (removeEmployee(idRemove)) {
                        System.out.println("Специалист с id " + (idRemove) + " исключен из списка." +
                                           "\nДля продолжения нажмите клавишу \"ВВОД\"");
                    } else {
                        System.out.println("Специалист с id " + (idRemove) + " не найден в списке." +
                                           "\nДля продолжения нажмите клавишу \"ВВОД\"");
                    }
                    scanPause.nextLine();
                    break;
                case 4:
                    System.out.println("""
                            ==ПОИСК СПЕЦИАЛИСТА==
                            Введите id сотрудника:\s""");
                    Scanner scn5 = new Scanner(System.in);
                    int idFind = scn5.nextInt();
                    String employeeFound = (findEmployee(idFind) != null) ? findEmployee(idFind).toString() : "Специалист не найден";
                    System.out.println(employeeFound + "\nДля продолжения нажмите клавишу \"ВВОД\"");
                    scanPause.nextLine();
                    break;
                case 5:
                    System.out.println("==СУММА ЗАТРАТ НА ЗАРПЛАТУ==" +
                                       "\nЗатраты на зарплату - " + countTotalSumSalary() +
                                       "\nДля продолжения нажмите клавишу \"ВВОД\"");
                    scanPause.nextLine();
                    break;
                case 6:
                    System.out.println("==МИНИМАЛЬНАЯ ЗАРПЛАТА==");
                    showEmployeeMinSalary();
                    System.out.println("\nДля продолжения нажмите клавишу \"ВВОД\"");
                    scanPause.nextLine();
                    break;
                case 7:
                    System.out.println("==МИНИМАЛЬНАЯ ЗАРПЛАТА==");
                    showEmployeeMaxSalary();
                    System.out.println("\nДля продолжения нажмите клавишу \"ВВОД\"");
                    scanPause.nextLine();
                    break;
                case 8:
                    System.out.println("==СРЕДНЯЯ ЗАРПЛАТА==" +
                                       "\nСредняя зарплата - " + findAvgSalary() +
                                       "\nДля продолжения нажмите клавишу \"ВВОД\"");
                    scanPause.nextLine();
                    break;
                case 9:
                    System.out.println("==ФИО ВСЕХ СОТРУДНИКОВ==");
                    getOnlyName();
                    System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                    scanPause.nextLine();
                    break;
                case 10:
                    System.out.println("==ИНДЕКСАЦИЯ ЗП==" +
                                       "\nВведите величину изменения зп (в %): ");
                    Scanner scn2 = new Scanner(System.in);
                    double percent = scn2.nextInt();
                    raiseSalary(percent);
                    getEmployee();
                    System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                    scanPause.nextLine();
                    break;
                case 11:
                    System.out.println("Введите номер отдела");
                    Scanner scanner1 = new Scanner(System.in);
                    int dep = scanner1.nextInt();
                    while (true) {
                        System.out.println(DEPARTMENT_MENU);
                        int choiceDepartment = scanChoice.nextInt();
                        switch (choiceDepartment) {
                            case 1:
                                System.out.println("==СПИСОК СОТРУДНИКОВ ПО ОТДЕЛУ==");
                                getEmployeeInDepart(dep);
                                System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                                scanPause.nextLine();
                                break;
                            case 2:
                                System.out.println("==СУММА ЗАТРАТ НА ЗАРПЛАТУ ПО ОТДЕЛУ==");
                                System.out.println("Затраты на зарплату в отделе " + dep + " - " + countTotalSumOfDepart(dep));
                                System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                                scanPause.nextLine();
                                break;
                            case 3:
                                System.out.println("==МИНИМАЛЬНАЯ ЗАРПЛАТА ПО ОТДЕЛУ==");
                                showEmployeeMinSalaryOfDepart(dep);
                                System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                                scanPause.nextLine();
                                break;
                            case 4:
                                System.out.println("==МАКСИМАЛЬНАЯ ЗАРПЛАТА ПО ОТДЕЛУ==");
                                showEmployeeMaxSalaryOfDepart(dep);
                                System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                                scanPause.nextLine();
                                break;
                            case 5:
                                System.out.println("==СРЕДНЯЯ ЗАРПЛАТА ПО ОТДЕЛУ==");
                                System.out.println("Средняя зарплата по отделу " + dep + " - " + findAvgSalaryInDepart(dep));
                                System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                                scanPause.nextLine();
                                break;
                            case 6:
                                System.out.println("==ИНДЕКСАЦИЯ ЗП==");
                                System.out.print("Введите величину изменения зп (в %) по отделу: ");
                                Scanner scn3 = new Scanner(System.in);
                                double percentInDep = scn3.nextInt();
                                raiseSalaryInDepart(dep, percentInDep);
                                getEmployeeInDepart(dep);
                                System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                                scanPause.nextLine();
                                break;
                            case 7:
                                break EXTERNAL;
                            default:
                                System.out.println("Введите корректное значения пункта меню");
                                System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                                scanPause.nextLine();
                                break;
                        }

                    }
                case 12:
                    System.out.println("==СПЕЦИАЛИСТЫ С ЗП МЕНЕЕ ЗНАЧЕНИЯ==");
                    System.out.println("Введите значение для поиска:");
                    Scanner scn3 = new Scanner(System.in);
                    double valueMin = scn3.nextInt();
                    showFoundMinSalary(valueMin);
                    System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                    scanPause.nextLine();
                    break;
                case 13:
                    System.out.println("==СПЕЦИАЛИСТЫ С ЗП БОЛЕЕ ЗНАЧЕНИЯ==");
                    System.out.println("Введите значение для поиска:");
                    Scanner scn4 = new Scanner(System.in);
                    double valueMax = scn4.nextInt();
                    showFoundMaxSalary(valueMax);
                    System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                    scanPause.nextLine();
                    break;
                case 14:
                    System.out.println("Работа завершена");
                    System.exit(0);
                default:
                    System.out.println("Введите корректное значения пункта меню");
                    System.out.println("Для продолжения нажмите клавишу \"ВВОД\"");
                    scanPause.nextLine();
                    break;

            }
        }
    }

    public EmployeeBook(int size) {
        employee = new Employee[size];
    }

    public void getEmployee() {
        if (countEmployee() != 0) {
            for (Employee value : employee) {
                if (value != null) {
                    System.out.println(value);
                }
            }
        } else {
            System.out.println("==Список пуст==");
        }
    }

    public void addEmployee(String lastName, String firstName, String patronymicName, int department, double salary) {
        employee[getIndex()] = new Employee(lastName, firstName, patronymicName, department, salary);
    }

    public boolean isEmptyIndex(Employee[] e) {
        for (int i = 0; i < e.length; i++) {
            if (e[i] == null) {
                setIndex(i);
                return true;
            }
        }
        return false;
    }

    public void enterEmployeeDataInMenu() {
        String lastName, firstName, patronymicName;
        int department;
        double salary;
        if (isEmptyIndex(employee)) {
            Scanner scn = new Scanner(System.in);
            System.out.println("Введите фамилию: ");
            lastName = scn.nextLine();
            System.out.println("Введите имя: ");
            firstName = scn.nextLine();
            System.out.println("Введите отчество: ");
            patronymicName = scn.nextLine();
            System.out.println("Введите номер отдела (1-5): ");
            department = scn.nextInt();
            if (!Employee.isDepartmentTrue(department)) {
                System.out.println("""
                        Введенный номер отдела не принадлежит диапазону от 1 до 5.
                        Введите номер отдела (1-5):\s""");
                department = scn.nextInt();
            }
            System.out.println("Введите ЗП: ");
            salary = scn.nextDouble();
            addEmployee(lastName, firstName, patronymicName, department, salary);
            System.out.println("Сотрудник добавлен.\n" +
                               "Для продолжения нажмите клавишу \"ВВОД\"");
        } else {
            System.out.println("Память для хранения списка заполнена.\n" +
                               "Для продолжения нажмите клавишу \"ВВОД\"");

        }
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        EmployeeBook.index = index;
    }

    public boolean removeEmployee(int id) {
        for (int i = 0; i < employee.length; i++) {
            if ((employee[i] != null) && (employee[i].getId() == id)) {
                employee[i] = null;
                return true;
            }
        }
        return false;
    }

    public Employee findEmployee(int id) {
        for (int i = 0; i < employee.length; i++) {
            if ((employee[i] != null) && (employee[i].getId() == id)) {
                setIndex(i);
                return employee[getIndex()];
            }
        }
        return null;
    }

    public double countTotalSumSalary() {
        double totalSum = 0.0;
        for (Employee value : employee) {
            if (value != null) {
                totalSum += value.getSalary();
            }
        }
        return totalSum;
    }

    public double findMinSalary() {
        double minSalary = 0;
        for (Employee employee : employee) {
            if (employee != null) {
                minSalary = employee.getSalary();
                break;
            }
        }
        for (Employee employee : employee) {
            if ((employee != null) && (minSalary > employee.getSalary())) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    public void showEmployeeMinSalary() {
        if (countEmployee() != 0) {
            for (Employee employee : employee) {
                if (employee != null && employee.getSalary() == findMinSalary()) {
                    System.out.println("Сотрудник с минимальной зарплатой в " + findMinSalary() + " - " + employee.getLastName() + " " +
                                       employee.getFirstName() + " " + employee.getPatronymicName());
                }
            }
        } else {
            System.out.println("==Список сотрудников пуст==");
        }
    }

    public double findMaxSalary() {
        double maxSalary = 0;
        for (Employee employee : employee) {
            if (employee != null) {
                maxSalary = employee.getSalary();
                break;
            }
        }
        for (Employee employee : employee) {
            if (employee != null && maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    public void showEmployeeMaxSalary() {
        if (countEmployee() != 0) {
            for (Employee employee : employee) {
                if (employee != null && employee.getSalary() == findMaxSalary()) {
                    System.out.println("Сотрудник с минимальной зарплатой в " + findMaxSalary() + " - " + employee.getLastName() + " " +
                                       employee.getFirstName() + " " + employee.getPatronymicName());
                }
            }
        } else {
            System.out.println("==Список сотрудников пуст==");
        }
    }

    public int countEmployee() {
        int i = 0;
        for (Employee employee : employee) {
            if (employee != null) {
                i++;
            }
        }
        return i;
    }

    public double findAvgSalary() {
        double avgSal = 0.0;
        if (countEmployee() != 0) {
            avgSal = countTotalSumSalary() / countEmployee();
        }
        avgSal = Math.ceil(avgSal * 100) / 100;
        return avgSal;
    }

    public void getOnlyName() {
        String str;
        if (countEmployee() != 0) {
            for (Employee employee : employee) {
                if (employee != null) {
                    str = employee.getLastName() + " " + employee.getFirstName() + " " + employee.getPatronymicName();
                    System.out.println(str);
                }
            }
        } else {
            System.out.println("==Список пуст==");
        }
    }

    public void raiseSalary(double percent) {
        for (Employee value : employee) {
            if (value != null) {
                double increase = value.getSalary() * (100 + percent) / 100;
                value.setSalary(increase);
            }
        }
    }

    public void getEmployeeInDepart(int d) {
        String str;
        if (countEmployeeInDepart(d) != 0) {
            for (Employee value : employee) {
                if (value != null && value.getDepartment() == d) {
                    String replace = "department=" + d + ", ";
                    str = value.toString().replace(replace, "");
                    System.out.println(str);
                }
            }
        } else {
            System.out.println("==Список пуст==");
        }
    }

    public double countTotalSumOfDepart(int d) {
        double totalSum = 0.0;
        for (Employee value : employee) {
            if (value != null && value.getDepartment() == d) {
                totalSum += value.getSalary();
            }
        }
        return totalSum;
    }

    public double findMinSalaryOfDepart(int d) {
        double minSalary = 0;
        for (Employee employee : employee) {
            if (employee != null) {
                minSalary = employee.getSalary();
                break;
            }
        }
        for (Employee employee : employee) {
            if (employee != null && employee.getDepartment() == d && minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    public void showEmployeeMinSalaryOfDepart(int d) {
        if (countEmployeeInDepart(d) != 0) {
            for (Employee employee : employee) {
                if (employee != null && employee.getSalary() == findMinSalaryOfDepart(d)) {
                    System.out.println("Сотрудник с минимальной зарплатой в " + findMinSalaryOfDepart(d) + " - " + employee.getLastName() + " " +
                                       employee.getFirstName() + " " + employee.getPatronymicName());
                }
            }
        } else {
            System.out.println("==Список сотрудников пуст==");
        }
    }

    public double findMaxSalaryOfDepart(int d) {
        double maxSalary = 0;
        for (Employee employee : employee) {
            if (employee != null) {
                maxSalary = employee.getSalary();
                break;
            }
        }
        for (Employee employee : employee) {
            if (employee != null && employee.getDepartment() == d && maxSalary > employee.getSalary()) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    public void showEmployeeMaxSalaryOfDepart(int d) {
        if (countEmployeeInDepart(d) != 0) {
            for (Employee employee : employee) {
                if (employee != null && employee.getSalary() == findMaxSalaryOfDepart(d)) {
                    System.out.println("Сотрудник с минимальной зарплатой в " + findMaxSalaryOfDepart(d) + " - " + employee.getLastName() + " " +
                                       employee.getFirstName() + " " + employee.getPatronymicName());
                }
            }
        } else {
            System.out.println("==Список сотрудников пуст==");
        }
    }

    public int countEmployeeInDepart(int d) {
        int i = 0;
        for (Employee value : employee) {
            if (value != null && value.getDepartment() == d) {
                i++;
            }
        }
        return i;
    }

    public double findAvgSalaryInDepart(int d) {
        double avgSal = 0;
        if (countEmployeeInDepart(d) != 0) {
            avgSal = countTotalSumOfDepart(d) / countEmployeeInDepart(d);
            avgSal = Math.ceil(avgSal * 100) / 100;
        }
        return avgSal;
    }

    public void raiseSalaryInDepart(int d, double percent) {
        for (Employee value : employee) {
            if (value != null && value.getDepartment() == d) {
                double increase = value.getSalary() * (100 + percent) / 100;
                value.setSalary(increase);
            }
        }
    }

    public void showFoundMinSalary(double val) {
        if (getCountSalaryLessThenValue(val) != 0) {
            for (Employee value : employee) {
                if ((value != null) && (value.getSalary() < val)) {
                    System.out.println("Сотрудники с ЗП меньше " + val + " - " +
                                       value.getId() + " " + value.getLastName() + " " + value.getFirstName() + " " +
                                       value.getPatronymicName() + " " + value.getSalary());
                }
            }
        } else {
            System.out.println("==Сотрудников с зп менее " + val + " - не найдено==");
        }
    }

    public int getCountSalaryLessThenValue(double val) {
        int i = 0;
        for (Employee value : employee) {
            if (value != null && value.getId() < val) {
                i++;
            }
        }
        return i;
    }

    public void showFoundMaxSalary(double val) {
        if (getCountSalaryMoreThenValue(val) != 0) {
            for (Employee value : employee) {
                if ((value != null) && (value.getSalary() > val)) {
                    System.out.println("Сотрудники с ЗП больше " + val + " - " +
                                       value.getId() + " " + value.getLastName() + " " + value.getFirstName() + " " +
                                       value.getPatronymicName() + " " + value.getSalary());
                }
            }
        } else {
            System.out.println("==Сотрудников с зп больше " + val + " - не найдено==");
        }
    }

    public int getCountSalaryMoreThenValue(double val) {
        int i = 0;
        for (Employee value : employee) {
            if (value != null && value.getId() > val) {
                i++;
            }
        }
        return i;
    }

}
