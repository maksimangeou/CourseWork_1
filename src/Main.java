import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanPause = new Scanner(System.in);
        //Хранилище объектов "сотрудник". Размер массива из командной строки
        System.out.print("Введите размер хранилища целочисленное значение: ");
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        System.out.println();
        EmployeeBook eBook = new EmployeeBook(size);
        int choice; //переменная выбора меню
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=============================================");
            System.out.println("|              MENU SELECTION               |");
            System.out.println("=============================================");
            System.out.println("|   1. Вывести список сотрудников           |");
            System.out.println("|   2. Добавить сотрудника в список         |");
            System.out.println("|   3. Удалить сотрудника из списка         |");
            System.out.println("|   4. Поиск специалиста по id              |");
            System.out.println("|   5. Сумма затрат по ЗП                   |");
            System.out.println("|   6. Минимальная ЗП                       |");
            System.out.println("|   7. Максимальная ЗП                      |");
            System.out.println("|   8. Средняя ЗП                           |");
            System.out.println("|   9. ФИО сотрудников                      |");
            System.out.println("|   10. Индексация ЗП                       |");
            System.out.println("|   11. Работа с отделами                   |");
            System.out.println("|   12. Поиск специалистов с ЗП менее числа |");
            System.out.println("|   13. Поиск специалистов с ЗП более числа |");
            System.out.println("|   14. Завершение работы                   |");
            System.out.println("=============================================");
            System.out.println("Введите номер пункта меню: ");
            choice = scanner.nextInt();
            EXTERNAL:
            switch (choice) {
                case 1:
                    System.out.println("==СПИСОК СОТРУДНИКОВ==");
                    eBook.getEmployee();
                    scanPause.nextLine();
                    break;
                case 2:
                    System.out.println("==ДОБАВИТЬ СОТРУДНИКА В СПИСОК==");
                    eBook.addEmployee();
                    scanPause.nextLine();
                    break;
                case 3:
                    System.out.println("==УДАЛИТЬ СОТРУДНИКА ИЗ СПИСКА==");
                    System.out.println("Введите id сотрудника для удаления: ");
                    Scanner scn1 = new Scanner(System.in);
                    int i = scn1.nextInt();
                    eBook.removeEmployee(i);
                    scanPause.nextLine();
                    break;
                case 4:
                    System.out.println("==ПОИСК СПЕЦИАЛИСТА==");
                    System.out.println("Введите id сотрудника: ");
                    Scanner scn5 = new Scanner(System.in);
                    int id = scn5.nextInt();
                    eBook.findEmployee(id);
                    scanPause.nextLine();
                    break;
                case 5:
                    System.out.println("==СУММА ЗАТРАТ НА ЗАРПЛАТУ==");
                    System.out.println("Затраты на зарплату - " + eBook.countTotalSumSalary());
                    System.out.println("Нажмите любую клавишу, чтобы продолжить");
                    scanPause.nextLine();
                    break;
                case 6:
                    System.out.println("==МИНИМАЛЬНАЯ ЗАРПЛАТА==");
                    eBook.findMinSalary();
                    System.out.println("Нажмите любую клавишу, чтобы продолжить");
                    scanPause.nextLine();
                    break;
                case 7:
                    System.out.println("==МАКСИМАЛЬНАЯ ЗАРПЛАТА==");
                    eBook.findMaxSalary();
                    System.out.println("Нажмите любую клавишу, чтобы продолжить");
                    scanPause.nextLine();
                    break;
                case 8:
                    System.out.println("==СРЕДНЯЯ ЗАРПЛАТА==");
                    System.out.println("Средняя зарплата - " + eBook.findAvgSalary());
                    System.out.println("Нажмите любую клавишу, чтобы продолжить");
                    scanPause.nextLine();
                    break;
                case 9:
                    System.out.println("==ФИО ВСЕХ СОТРУДНИКОВ==");
                    eBook.getOnlyName();
                    System.out.println("Нажмите любую клавишу, чтобы продолжить");
                    scanPause.nextLine();
                    break;
                case 10:
                    System.out.println("==ИНДЕКСАЦИЯ ЗП==");
                    System.out.print("Введите величину изменения зп (в %): ");
                    Scanner scn2 = new Scanner(System.in);
                    double percent = scn2.nextInt();
                    eBook.raiseSalary(percent);
                    scanPause.nextLine();
                    break;
                case 11:
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
                        System.out.println("Введите номер пункта меню: ");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("==СПИСОК СОТРУДНИКОВ ПО ОТДЕЛУ==");
                                eBook.getEmployeeInDepart(dep);
                                System.out.println("Нажмите любую клавишу, чтобы продолжить");
                                scanPause.nextLine();
                                break;
                            case 2:
                                System.out.println("==СУММА ЗАТРАТ НА ЗАРПЛАТУ ПО ОТДЕЛУ==");
                                System.out.println("Затраты на зарплату в отделе" + dep + " - " + eBook.countTotalSumOfDepart(dep));
                                System.out.println("Нажмите любую клавишу, чтобы продолжить");
                                scanPause.nextLine();
                                break;
                            case 3:
                                System.out.println("==МИНИМАЛЬНАЯ ЗАРПЛАТА ПО ОТДЕЛУ==");
                                eBook.findMinSalaryOfDepart(dep);
                                System.out.println("Нажмите любую клавишу, чтобы продолжить");
                                scanPause.nextLine();
                                break;
                            case 4:
                                System.out.println("==МАКСИМАЛЬНАЯ ЗАРПЛАТА ПО ОТДЕЛУ==");
                                eBook.findMaxSalaryOfDepart(dep);
                                System.out.println("Нажмите любую клавишу, чтобы продолжить");
                                scanPause.nextLine();
                                break;
                            case 5:
                                System.out.println("==СРЕДНЯЯ ЗАРПЛАТА ПО ОТДЕЛУ==");
                                System.out.println("Средняя зарплата по отделу" + dep + " - " + eBook.findAvgSalaryInDepart(dep));
                                System.out.println("Нажмите любую клавишу, чтобы продолжить");
                                scanPause.nextLine();
                                break;
                            case 6:
                                System.out.println("==ИНДЕКСАЦИЯ ЗП==");
                                System.out.print("Введите величину изменения зп (в %) по отделу: ");
                                Scanner scn3 = new Scanner(System.in);
                                double percentInDep = scn3.nextInt();
                                eBook.raiseSalaryInDepart(dep, percentInDep);
                                System.out.println("Нажмите любую клавишу, чтобы продолжить");
                                scanPause.nextLine();
                                break;
                            case 7:
                                break EXTERNAL;
                            default:
                                System.out.println("Введите корректное значения пункта меню");
                                System.out.println("Нажмите любую клавишу, чтобы продолжить");
                                scanPause.nextLine();
                                break;
                        }

                    }
                case 12:
                    System.out.println("==СПЕЦИАЛИСТЫ С ЗП МЕНЕЕ ЗНАЧЕНИЯ==");
                    System.out.println("Введите значение для поиска:");
                    Scanner scn3 = new Scanner(System.in);
                    double valueMin = scn3.nextInt();
                    eBook.getFindMinSalary(valueMin);
                    System.out.println("Нажмите любую клавишу, чтобы продолжить");
                    scanPause.nextLine();
                    break;
                case 13:
                    System.out.println("==СПЕЦИАЛИСТЫ С ЗП БОЛЕЕ ЗНАЧЕНИЯ==");
                    System.out.println("Введите значение для поиска:");
                    Scanner scn4 = new Scanner(System.in);
                    double valueMax = scn4.nextInt();
                    eBook.getFindMaxSalary(valueMax);
                    System.out.println("Нажмите любую клавишу, чтобы продолжить");
                    scanPause.nextLine();
                    break;
                case 14:
                    System.out.println("Работа завершена");
                    System.exit(0);
                default:
                    System.out.println("Введите корректное значения пункта меню");
                    System.out.println("Нажмите любую клавишу, чтобы продолжить");
                    scanPause.nextLine();
                    break;

            }
        }

    }

}