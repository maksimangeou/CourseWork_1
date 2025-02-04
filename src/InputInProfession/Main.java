package InputInProfession;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Введите размер хранилища целочисленное значение: ");
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        System.out.println();
        EmployeeBook eBook = new EmployeeBook(size);
        eBook.manageMenu();
    }

}