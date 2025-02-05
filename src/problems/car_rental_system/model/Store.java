package problems.car_rental_system.model;

import problems.car_rental_system.enums.VehicleType;
import problems.car_rental_system.model.product.Car;
import problems.car_rental_system.model.product.Vehicle;
import problems.car_rental_system.services.VehicleInventoryManagement;
import problems.car_rental_system.services.impl.CarInventoryManagement;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public int storeId;
    VehicleInventoryManagement inventoryManagement;
    Location storeLocation;
    List<Reservation> reservations = new ArrayList<>();


    public List<Vehicle> getVehicles(VehicleType vehicleType) {

        return inventoryManagement.getVehicles();
    }


    //addVehicles, update vehicles, use inventory management to update those.


    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement = new CarInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation = new Reservation();
        reservation.createReserve(user,vehicle);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationID) {

        //take out the reservation from the list and call complete the reservation method.
        return true;
    }

    //update reservation

}
