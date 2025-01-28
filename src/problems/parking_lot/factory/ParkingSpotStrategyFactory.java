package problems.parking_lot.factory;

import problems.parking_lot.enums.VehicleType;
import problems.parking_lot.strategy.FourWheelerParkingStrategy;
import problems.parking_lot.strategy.ParkingStrategy;
import problems.parking_lot.strategy.ThreeWheelerParkingStrategy;
import problems.parking_lot.strategy.TwoWheelerParkingStrategy;

public class ParkingSpotStrategyFactory {
    private ParkingStrategy parkingStrategy;
    public ParkingStrategy getParkingSpotStrategy(VehicleType vehicleType) {
        switch (vehicleType) {
            case TWO_WHEEL -> parkingStrategy = new TwoWheelerParkingStrategy();
            case THREE_WHEEL -> parkingStrategy = new ThreeWheelerParkingStrategy();
            case FOUR_WHEEL -> parkingStrategy = new FourWheelerParkingStrategy();
        }
        return parkingStrategy;
    }

}
