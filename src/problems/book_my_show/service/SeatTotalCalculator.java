package problems.book_my_show.service;

import problems.book_my_show.controller.MovieTicketBookingSystem;
import problems.book_my_show.model.Seat;

import java.util.List;

public class SeatTotalCalculator {
    private final PricingStrategy pricingStrategy;

    public SeatTotalCalculator(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double seatTotal(List<Seat> seats) {
        return pricingStrategy.calculatePrice(seats);
    }


}
