package lld.parkingLot.FareCalculator.FareStrategy;

import java.math.BigDecimal;

import lld.parkingLot.Ticket;

public interface FareStrategy {
    BigDecimal CalculateFare(Ticket ticket, BigDecimal inputFare);
}
