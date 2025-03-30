package problems.book_my_show;

import problems.book_my_show.controller.MovieTicketBookingSystem;
import problems.book_my_show.enums.SeatStatus;
import problems.book_my_show.enums.SeatType;
import problems.book_my_show.exception.SeatAlreadyBookedException;
import problems.book_my_show.model.*;
import problems.book_my_show.service.SeatPriceFactory;

import java.time.LocalDateTime;
import java.util.*;


public class BookMyShowDemo {
    public static void main(String[] args) {
        MovieTicketBookingSystem bookingSystem = MovieTicketBookingSystem.getInstance();

        // Add movies
        Movie movie1 = new Movie("M1", "Movie 1", "Description 1", 120);
        Movie movie2 = new Movie("M2", "Movie 2", "Description 2", 135);
        bookingSystem.addMovie(movie1);
        bookingSystem.addMovie(movie2);

        // Add theaters
        Theater theater1 = new Theater("T1", "Theater 1", "Location 1", new ArrayList<>());
        Theater theater2 = new Theater("T2", "Theater 2", "Location 2", new ArrayList<>());
        bookingSystem.addTheater(theater1);
        bookingSystem.addTheater(theater2);

        // Add shows
        Show show1 = new Show("S1", movie1, theater1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie1.getDuration()), createSeats('Z', 2));
        Show show2 = new Show("S2", movie2, theater2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie2.getDuration()), createSeats('P', 2));
        bookingSystem.addShow(show1);
        bookingSystem.addShow(show2);

        // Book tickets
        User user = new User("U1", "John Doe", "john@example.com");
        List<Seat> selectedSeats = Arrays.asList(show1.getSeats().get("A-2"), show1.getSeats().get("B-2"));
        Booking booking = bookingSystem.bookTickets(user, show1, selectedSeats);
        if (booking != null) {
            System.out.println("Booking successful. Booking ID: " + booking.getId() + "total price:" + booking.getTotalPrice());
            bookingSystem.confirmBooking(booking.getId());
        }

        User user2 = new User("U2", "John Doe", "john@example.com");
        List<Seat> selectedSeats2 = Arrays.asList(show1.getSeats().get("A-2"), show1.getSeats().get("Z-2"));
        try {
            Booking booking2 = bookingSystem.bookTickets(user2, show1, selectedSeats2);
            if (booking2 != null) {
                System.out.println("Booking successful. Booking ID: " + booking2.getId() + "total price:" + booking2.getTotalPrice());
                bookingSystem.confirmBooking(booking2.getId());
            }
        } catch (SeatAlreadyBookedException e) {
            System.out.println(e.getMessage());
        }


        // Cancel booking
        bookingSystem.cancelBooking(booking.getId());
        System.out.println("Booking canceled. Booking ID: " + booking.getId());

        Booking booking3 = bookingSystem.bookTickets(user2, show1, selectedSeats2);
        if (booking3 != null) {
            System.out.println("Booking successful. Booking ID: " + booking3.getId() + "total price:" + booking3.getTotalPrice());
            bookingSystem.confirmBooking(booking3.getId());
        }

    }

    private static Map<String, Seat> createSeats(char rows, int columns) {
        Map<String, Seat> seats = new LinkedHashMap<>();
        for (char row = 'A'; row <= rows; row++) {
            for (int col = 1; col <= columns; col++) {
                String seatId = row + "-" + col;
                SeatType seatType = (row <= 'I') ? SeatType.DIAMOND : (row <= 'P') ? SeatType.GOLD :  SeatType.SILVER;
                double price = new SeatPriceFactory().getPrice(seatType);
                Seat seat = new Seat(seatId, row, col, seatType, price, SeatStatus.AVAILABLE);
                seats.put(seatId, seat);
            }
        }
        return seats;
    }
}
