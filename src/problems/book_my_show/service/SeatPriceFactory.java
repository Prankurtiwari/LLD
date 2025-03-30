package problems.book_my_show.service;

import problems.book_my_show.enums.SeatType;

public class SeatPriceFactory {

    public double getPrice(SeatType seatType) {
        double price = 0.0;
        switch (seatType) {
            case SILVER -> price = 100;
            case GOLD -> price = 150;
            case DIAMOND -> price = 300;
            default -> price = Double.MAX_VALUE;
        }
        return price;
    }
}
