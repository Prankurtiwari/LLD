package problems.book_my_show.service.impl;

import problems.book_my_show.model.Seat;
import problems.book_my_show.service.PricingStrategy;

import java.util.List;

public class AvgPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(List<Seat> selectedSeats) {
        return (selectedSeats.stream().mapToDouble(Seat::getPrice).sum()) / selectedSeats.size();
    }

}
