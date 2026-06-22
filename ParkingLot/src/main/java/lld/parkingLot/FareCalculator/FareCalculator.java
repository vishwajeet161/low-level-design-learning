package lld.parkingLot.FareCalculator;

import java.math.BigDecimal;
import java.util.List;

import lld.parkingLot.Ticket;
import lld.parkingLot.FareCalculator.FareStrategy.FareStrategy;

public class FareCalculator {
    private List<FareStrategy> fareStrategies;

    public FareCalculator(List<FareStrategy> fareStrategies) {
        this.fareStrategies = fareStrategies;
    }

    public BigDecimal calculateFare(Ticket ticket) {
        BigDecimal fare = BigDecimal.ZERO;
        for (FareStrategy strategy : fareStrategies) {
            fare = strategy.CalculateFare(ticket, fare);
        }
        return fare;
    }
}
