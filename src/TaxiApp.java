import com.taxiapp.client.Client;
import com.taxiapp.driver.Driver;

import java.util.Scanner;

public class TaxiApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Главное меню такси");
            System.out.println("1. Водитель");
            System.out.println("2. Клиент");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> Driver.callDriverMenu(scanner);
                    case 2 -> Client.callClientMenu(scanner);
                    case 0 -> exit = true;
                    default -> System.out.println("Данной операции не существует. Введите 0, 1 или 2.");
                }
            }
            else {
                System.out.println("Укажите число.");
                scanner.next();
            }
        }

        scanner.close();
        System.out.println("Выход с программы.");
    }
}
