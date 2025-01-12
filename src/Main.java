public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[10];

        employee[0] = new Employee("Задорожный","Максим","Петрович","1",150000.0);
        employee[1] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[2] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[3] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[4] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[5] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[6] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[7] = new Employee("Зад","Макс","Петр","6",150000.0);
        employee[8] = new Employee("Зад","Макс","Петр","2",150000.0);
        employee[9] = new Employee("Зад","Макс","Петр","2",150000.0);
        for (int i=0; i<10;i++) {
            System.out.println(employee[i].getId() + " " +
                    employee[i].getLastName() + " " +
                    employee[i].getFirstName() + " " +
                    employee[i].getPatronymicName() + " " +
                    employee[i].getDepartment() + " " + employee[0].getSalary()
            );
        }
    }
}