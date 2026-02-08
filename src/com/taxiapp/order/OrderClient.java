package com.taxiapp.order;

import com.taxiapp.date.DateTaxiApp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderClient {
    public static void callOrder(Scanner scanner) {
        System.out.println("Введите свой адрес: ");
        scanner.nextLine();
        String addressClient = scanner.nextLine();

        if (addressClient.isEmpty()) {
            System.out.println("Адрес не может быть пустым.");
            return;
        }

        try (
             FileWriter fileWriter = new FileWriter(Order.FILE_ORDERS_NAME, true);
        ) {

            fileWriter.write(addressClient + " " + DateTaxiApp.getDate() + "\n");
            System.out.println("Такси вызвано, ожидайте.");
        }
        catch (IOException e) {
            System.err.println("Произошла ошибка при сохранении заказа. " + e.getMessage());
        }
    }
}
