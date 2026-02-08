package com.taxiapp.order;

import com.taxiapp.price_algorithm.PriceAlgorithm;

public class Order {
    public static double getOrderTariff() {
        return PriceAlgorithm.getPrice();
    }
}
