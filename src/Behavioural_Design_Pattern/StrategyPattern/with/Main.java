package Behavioural_Design_Pattern.StrategyPattern.with;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();

        Vehicle v1 = new GoodsVehicle();
        Vehicle v2 = new PassengerVehicle();
        Vehicle v3 = new SportVehicle();
        Vehicle v4 = new OffRoadVehicle();

        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);

        for (Vehicle v : list) {
            v.drive();
        }
    }
}
