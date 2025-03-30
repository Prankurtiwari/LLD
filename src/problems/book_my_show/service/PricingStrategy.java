package problems.book_my_show.service;

import problems.book_my_show.model.Seat;

import java.util.List;

public interface PricingStrategy {
    double calculatePrice (List<Seat> selectedSeats);
}
