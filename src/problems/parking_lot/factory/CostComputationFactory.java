package problems.parking_lot.factory;

import problems.parking_lot.enums.VehicleType;
import problems.parking_lot.model.FourWheelerParkingSpot;
import problems.parking_lot.model.ParkingSpot;
import problems.parking_lot.model.ThreeWheelerParkingSpot;
import problems.parking_lot.model.TwoWheelerParkingSpot;
import problems.parking_lot.strategy.CostComputationStrategy;
import problems.parking_lot.strategy.HourlyCostComputation;
import problems.parking_lot.strategy.MinutesCostComputation;
import problems.parking_lot.strategy.TwoWheelerParkingStrategy;

public class CostComputationFactory {
    private CostComputationStrategy costComputationStrategy;
    public CostComputationStrategy getCostComputationStrategy(VehicleType vehicleType) {
        switch (vehicleType) {
            case TWO_WHEEL :
            case THREE_WHEEL :
                costComputationStrategy = new HourlyCostComputation();
                break;
            case FOUR_WHEEL:
                costComputationStrategy = new MinutesCostComputation();
                break;
        }
        return costComputationStrategy;
    }

}
