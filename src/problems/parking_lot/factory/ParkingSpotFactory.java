package problems.parking_lot.factory;

import problems.parking_lot.enums.VehicleType;
import problems.parking_lot.model.FourWheelerParkingSpot;
import problems.parking_lot.model.ParkingSpot;
import problems.parking_lot.model.ThreeWheelerParkingSpot;
import problems.parking_lot.model.TwoWheelerParkingSpot;
import problems.parking_lot.strategy.FourWheelerParkingStrategy;
import problems.parking_lot.strategy.ParkingStrategy;
import problems.parking_lot.strategy.ThreeWheelerParkingStrategy;
import problems.parking_lot.strategy.TwoWheelerParkingStrategy;

public class ParkingSpotFactory {
    private ParkingSpot parkingSpot;
    public ParkingSpot getParkingSpotStrategy(VehicleType vehicleType) {
        switch (vehicleType) {
            case TWO_WHEEL -> parkingSpot = new TwoWheelerParkingSpot();
            case THREE_WHEEL -> parkingSpot = new ThreeWheelerParkingSpot();
            case FOUR_WHEEL -> parkingSpot = new FourWheelerParkingSpot();
        }
        return parkingSpot;
    }

}
