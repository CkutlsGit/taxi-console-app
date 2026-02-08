package com.taxiapp.driver;

import com.taxiapp.order.OrderDriver;

import java.util.Scanner;

public class Driver {
    public static void callDriverMenu(Scanner scanner) {
        while (true) {
            System.out.println("Меню водителя.");
            System.out.println("1. Посмотреть список заказов");
            System.out.println("2. Взять заказ");
            System.out.println("9. Вернуться в главное меню");
            System.out.println("0. Выйти из программы");
            System.out.println("Выбор: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> OrderDriver.getOrders();
                    case 2 -> OrderDriver.takeOrder(scanner);
                    case 9 -> { return; }
                    case 0 -> System.exit(0);
                    default -> System.out.println("Данной операции не существует. Введите 0, 1, 2 или 9");
                }
            }
            else {
                System.out.println("Укажите число.");
                scanner.next();
            }
        }
    }
}
