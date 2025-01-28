package problems.parking_lot.model;

import problems.parking_lot.factory.CostComputationFactory;
import problems.parking_lot.strategy.CostComputationStrategy;

public class Exit {
    private Ticket ticket;
    private ParkingSpot parkingSpot;
    public void payPrice() {
        new CostComputationFactory().getCostComputationStrategy(ticket.getVehicle().getVehicleType()).calculateCostForTicket(ticket);
    }
    public void vacateParking() {
        parkingSpot.vacateParkingSpot();
    }
}
