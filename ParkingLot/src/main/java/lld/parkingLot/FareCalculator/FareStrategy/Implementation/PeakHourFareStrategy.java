package lld.parkingLot.FareCalculator.FareStrategy.Implementation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lld.parkingLot.Ticket;
import lld.parkingLot.FareCalculator.FareStrategy.FareStrategy;

public class PeakHourFareStrategy implements FareStrategy {

    private static final BigDecimal PEAK_HOUR_MULTIPLIER = new BigDecimal("1.5");

    public PeakHourFareStrategy() {};


    @Override
    public BigDecimal CalculateFare(Ticket ticket, BigDecimal inputFare) {
        BigDecimal fare = inputFare;
        if(isPeakHour(ticket.getEntryTime())) {
            fare = fare.multiply(PEAK_HOUR_MULTIPLIER);
        }
        return fare;
    }

    private boolean isPeakHour(LocalDateTime time) {
        int hour = time.getHour();
        return (hour >= 7 && hour < 10) || (hour >= 17 && hour < 20);
    }

}
