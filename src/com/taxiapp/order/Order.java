package com.taxiapp.order;

import com.taxiapp.price_algorithm.PriceAlgorithm;

public class Order {
    public final static String FILE_ORDERS_NAME = "orders.txt";

    public static double getOrderTariff() {
        return PriceAlgorithm.getPrice();
    }
}
