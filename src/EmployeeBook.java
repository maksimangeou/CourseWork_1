import java.util.Scanner;

public class EmployeeBook {
    private static Employee[] employee;
    private static int index = 0;


    public EmployeeBook(int size) {
        employee = new Employee[size];
    }

    public void getEmployee() {
        for (Employee value : employee) {
            if (value != null) {
                System.out.println(value);
            }
        }
        System.out.println("Конец списка. Нажмите любую клавишу");
    }

    public void addEmployee() {
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
                System.out.println("Введенный номер отдела не принадлежит диапазону от 1 до 5.");
                System.out.println("Введите номер отдела (1-5): ");
                department = scn.nextInt();
            }
            System.out.println("Введите ЗП: ");
            salary = scn.nextDouble();
            employee[index] = new Employee(lastName, firstName, patronymicName, department, salary);
            System.out.println("Сотрудник добавлен.");
            System.out.println("Для продолжения нажмите любую клавишу");
        } else {
            System.out.println("Память для хранения списка заполнена.");
            System.out.println("Для продолжения нажмите любую клавишу");

        }
    }

    public void removeEmployee(int id) {
        if ((employee[id - 1] != null) && (id < employee.length)) {
            employee[id - 1] = null;
            System.out.println("Специалист с id " + (id) + " исключен из списка. Для продолжения нажмите любую клавишу");
        } else {
            System.out.println("Специалист с id " + (id) + " не найден в списке. Для продолжения нажмите любую клавишу");
        }
    }

    public boolean isEmptyIndex(Employee[] e) {
        for (int i = 0; i < e.length; i++) {
            if (e[i] == null) {
                index = i;
                return true;
            }
        }
        return false;
    }

    public void findEmployee(int id) {
        System.out.println("Специалист - " + employee[id - 1].toString());
        System.out.println("Для продолжения нажмите любую клавишу.");
    }

    public double getTotalSumSalary() {
        double totalSum = 0.0;
        for (Employee value : employee) {
            totalSum += value.getSalary();
        }
        return totalSum;
    }

    public void getMinSalary() {
        double minSalary = Integer.MAX_VALUE;
        for (Employee value : employee) {
            if (minSalary > value.getSalary()) {
                minSalary = value.getSalary();
            }
        }
        for (Employee employee : employee) {
            if (minSalary == employee.getSalary()) {
                System.out.println("Сотрудник с минимальной зарплатой в " + minSalary + " - " + employee.getLastName() + " " +
                        employee.getFirstName() + " " + employee.getPatronymicName());
            }
        }
    }

    public void getMaxSalary() {
        double maxSalary = Integer.MIN_VALUE;
        for (Employee value : employee) {
            if (maxSalary < value.getSalary()) {
                maxSalary = value.getSalary();
            }
        }
        for (Employee value : employee) {
            if (maxSalary == value.getSalary()) {
                System.out.println("Сотрудник с максимальной зарплатой в " + maxSalary + " - " + value.getLastName() + " " +
                        value.getFirstName() + " " + value.getPatronymicName());
            }
        }
    }

    public double getAvgSalary() {
        double avgSal = getTotalSumSalary() / (Employee.getNextID() - 1);
        avgSal = Math.ceil(avgSal * 100) / 100;
        return avgSal;
    }

    public void getOnlyFIOName() {
        String str;
        for (Employee value : employee) {
            str = value.getLastName() + " " + value.getFirstName() + " " + value.getPatronymicName();
            System.out.println(str);
        }
    }

    public void setIncreaseSalary(double percent) {
        for (Employee value : employee) {
            double increase = value.getSalary() * (100 + percent) / 100;
            value.setSalary(increase);
        }
        getEmployee();
    }

    //Работа с отделами
    public void getEmployeeInDepart(int d) {
        String str;
        for (Employee value : employee)
            if (value.getDepartment() == d) {
                str = value.getId() + " " + value.getLastName() + " " + value.getFirstName() + " " +
                        value.getPatronymicName() + " " + value.getSalary();
                System.out.println(str);
            }
    }

    public double getTotalSumOfDepart(int d) {
        double totalSum = 0.0;
        for (Employee value : employee) {
            if (value.getDepartment() == d) {
                totalSum += value.getSalary();
            }
        }
        return totalSum;
    }

    public void getMinSalaryOfDepart(int d) {
        double minSalary = Integer.MAX_VALUE;
        for (Employee value : employee) {
            if (value.getDepartment() == d) {
                if (minSalary > value.getSalary()) {
                    minSalary = value.getSalary();
                }
            }
        }
        for (Employee employee : employee) {
            if ((minSalary == employee.getSalary()) && (d == employee.getDepartment())) {
                System.out.println("Сотрудник с минимальной зарплатой в " + minSalary +
                        " в отделе " + employee.getDepartment() + " - " +
                        employee.getLastName() + " " + employee.getFirstName() + " " + employee.getPatronymicName());
            }
        }
    }

    public void getMaxSalaryOfDepart(int d) {
        double maxSalary = Integer.MIN_VALUE;
        for (Employee value : employee) {
            if (value.getDepartment() == d) {
                if (maxSalary < value.getSalary()) {
                    maxSalary = value.getSalary();
                }
            }
        }
        for (Employee value : employee) {
            if ((maxSalary == value.getSalary()) && (d == value.getDepartment())) {
                System.out.println("Сотрудник с максимальной зарплатой в " + maxSalary +
                        " в отделе " + value.getDepartment() + " -  " + value.getLastName() + " " +
                        value.getFirstName() + " " + value.getPatronymicName());
            }
        }
    }

    public double getAvgSalaryInDepart(int d) {
        int i = 0;
        for (Employee value : employee) {
            if (value.getDepartment() == d) i++;
        }
        double avgSal = getTotalSumOfDepart(d) / i;
        return Math.ceil(avgSal * 100) / 100;
    }

    public void setIncreaseSalaryInDepart(int d, double percent) {
        for (Employee value : employee) {
            if (value.getDepartment() == d) {
                double increase = value.getSalary() * (100 + percent) / 100;
                value.setSalary(increase);
                System.out.println(value);
            }
        }
    }

    public void getFindMinSalary(double val) {
        for (Employee value : employee) {
            if (value.getSalary() < val) {
                System.out.println("Сотрудники с ЗП меньше " + val + " - " +
                        value.getId() + " " + value.getLastName() + " " + value.getFirstName() + " " +
                        value.getPatronymicName() + " " + value.getSalary());
            }
        }
    }

    public void getFindMaxSalary(double val) {
        for (Employee value : employee) {
            if (value.getSalary() > val) {
                System.out.println("Сотрудники с ЗП больше " + val + " - " +
                        value.getId() + " " + value.getLastName() + " " + value.getFirstName() + " " +
                        value.getPatronymicName() + " " + value.getSalary());
            }
        }
    }
}
