package com.taxiapp.order;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class OrderDriver {
    public static void getOrders() {
        try (
             Scanner scanner = new Scanner(new File(Order.FILE_ORDERS_NAME));
        ) {
            int count = 1;

            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                System.out.println(count + " " + nextLine);

                count++;
            }
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int getNumbersOrders() {
        int countOrders = 0;
        try (
             Scanner scanner = new Scanner(new File(Order.FILE_ORDERS_NAME));
        ) {
            while (scanner.hasNext()) {
                scanner.nextLine();
                countOrders += 1;
            }
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return  countOrders;
    }

    public static void deleteOrder(int numberOrder) {
        Path filePath = Paths.get(Order.FILE_ORDERS_NAME);

        if (!Files.exists(filePath)) {
            System.out.println("Файл заказов не найден.");
            return;
        }

        try {
            List<String> allLines = Files.readAllLines(filePath);

            if (numberOrder < 1 || numberOrder > allLines.size()) {
                System.out.println("Неверный номер заказа.");
                return;
            }

            allLines.remove(numberOrder - 1);

            Files.write(filePath, allLines);

            System.out.println("Заказ №" + numberOrder + " успешно удален.");
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void takeOrder(Scanner scanner) {
        int countOrders = getNumbersOrders();

        System.out.println("Введите номер заказа, который хотите взять");
        scanner.nextLine();

        if (scanner.hasNextInt()) {
            int numberOrder = scanner.nextInt();

            if (numberOrder < 1 || numberOrder > countOrders) {
                System.out.println("Такого номера заказа не существует.");
            }

            try (
                 Scanner scannerFile = new Scanner(new File(Order.FILE_ORDERS_NAME));
            ) {
                int count = 0;
                int lineNeeded = numberOrder - 1;

                while (scannerFile.hasNext()) {
                    String nextLine = scannerFile.nextLine();

                    if (count == lineNeeded) {
                        System.out.println("Вы взяли заказ под номером " + numberOrder + ", заказ: " + nextLine);
                        deleteOrder(numberOrder);
                    }

                    count++;
                }
            }
            catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        else {
            System.out.println("Введите число.");
        }
    }
}
