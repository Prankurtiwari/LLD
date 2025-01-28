package problems.parking_lot.strategy;

import problems.parking_lot.model.Ticket;

public interface CostComputationStrategy {
    double calculateCostForTicket(Ticket ticket);
}
