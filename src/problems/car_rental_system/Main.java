package problems.car_rental_system;

import problems.car_rental_system.enums.VehicleType;
import problems.car_rental_system.model.*;
import problems.car_rental_system.model.product.Bill;
import problems.car_rental_system.model.product.Car;
import problems.car_rental_system.model.product.Vehicle;
import problems.car_rental_system.services.VehicleRentalSystem;

import java.util.List;

import static problems.car_rental_system.seeders.Seeders.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        //0. User comes
        User user = users.get(0);

        //1. user search store based on location
        Location location = new Location("BTM layout", 403012, "Bangalore", "Karnataka", "India");
        Store store = rentalSystem.getStore(location);

        //2. get All vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);


        //3.reserving the particular vehicle
        Reservation reservation = store.createReservation(storeVehicles.get(0), users.get(0));

        //4. generate the bill
        Bill bill = new Bill(reservation);

        //5. make payment
        Payment payment = new Payment();
        payment.payBill(bill);

        //6. trip completed, submit the vehicle and close the reservation
        boolean completeReservation = store.completeReservation(reservation.reservationId);

        if(completeReservation) {
            System.out.println("Reservation with id : " + reservation.reservationId + " is completed.");
        }

    }
}
