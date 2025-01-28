package problems.parking_lot.strategy;

import problems.parking_lot.factory.ParkingSpotStrategyFactory;
import problems.parking_lot.model.Ticket;

import java.sql.Timestamp;

public class HourlyCostComputation implements CostComputationStrategy{
    @Override
    public double calculateCostForTicket(Ticket ticket) {
       long noOfHours = ticket.getEndTime().getTime() - ticket.getStartTime().getTime();
       int basePrice = new ParkingSpotStrategyFactory()
                .getParkingSpotStrategy(ticket.getVehicle().getVehicleType()).basePrice();
        return (double) noOfHours * basePrice;
    }
}
