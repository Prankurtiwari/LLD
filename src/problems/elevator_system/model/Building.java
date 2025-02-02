package problems.elevator_system.model;

import java.util.List;

public class Building {
    private List<Floor> floors;

    public Building(List<Floor> floors) {
        this.floors = floors;
    }

    public void addFloors(Floor floor) {
        floors.add(floor);
    }

    public void removeFloor(Floor floor) {
        floors.remove(floor);
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
