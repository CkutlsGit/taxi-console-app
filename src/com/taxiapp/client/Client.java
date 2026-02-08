package com.taxiapp.client;

import com.taxiapp.order.Order;
import com.taxiapp.order.OrderClient;

import java.util.Scanner;

public class Client {
    public static void callClientMenu(Scanner scanner) {
        while (true) {
            System.out.println("Меню клиента.");
            System.out.println("1. Вызвать такси");
            System.out.println("2. Узнать текущий тариф");
            System.out.println("9. Вернуться в главное меню");
            System.out.println("0. Выйти из программы");
            System.out.println("Выбор: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> OrderClient.callOrder();
                    case 2 -> Order.getOrderTariff();
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
