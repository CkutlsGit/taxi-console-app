package com.taxiapp.price_algorithm;

import com.taxiapp.date.DateTaxiApp;

public class PriceAlgorithm {
    private static final int START_PRICE = 250;

    private static final int PRICE_ONE_KM = 15;
    private static final int BASE_KM = 3;
    private static final int PICKUP_PRICE_PER_KM = 5;

    private static final int TRIP_DISTANCE_KM = 12;
    private static final int DISTANCE_TO_CLIENT = 2;

    private static final int TRAFFIC_JAM = 2;
    private static final boolean BAD_WEATHER = false;
    private static final boolean IS_DRIVERS_MORE = true;
    // CONST VALUES. TODO: ALG MENU FOR INPUT VALUES

    public static double getExtraKmPrice() {
        double tripCost;

        if (TRIP_DISTANCE_KM <= BASE_KM) {
            tripCost = START_PRICE;
        }
        else {
            int extraKm = TRIP_DISTANCE_KM - BASE_KM;
            tripCost = START_PRICE + extraKm * PRICE_ONE_KM;
        }

        double pickupCost = DISTANCE_TO_CLIENT * PICKUP_PRICE_PER_KM;

        return tripCost + pickupCost;
    }

    public static double getPrice() {
        int hoursNow = DateTaxiApp.getHoursDate();

        double finalPrice = getExtraKmPrice();

        if (IS_DRIVERS_MORE) {
            finalPrice += finalPrice * (45.0 / 100.0);
        }

        if (BAD_WEATHER) {
            finalPrice += finalPrice * (35.0 / 100.0);
        }

        if (TRAFFIC_JAM >= 5) {
            finalPrice += finalPrice * (3.5 * TRAFFIC_JAM / 100.0);
        }

        if (hoursNow >= 0 && hoursNow <= 4) {
            finalPrice += finalPrice * (10.0 / 100.0);
        }

        return finalPrice;
    }
}
