package lld.parkingLot.FareCalculator.FareStrategy.Implementation;

import java.math.BigDecimal;

import lld.parkingLot.Ticket;
import lld.parkingLot.FareCalculator.FareStrategy.FareStrategy;

public class BaseFareStrategy implements FareStrategy {
    private static final BigDecimal LARGE_VEHICLE_RATE = new BigDecimal("3.0");
    private static final BigDecimal SMALL_VEHICLE_RATE = new BigDecimal("1.0");
    private static final BigDecimal MEDIUM_VEHICLE_RATE = new BigDecimal("2.0");

    @Override
    public BigDecimal CalculateFare(Ticket ticket, BigDecimal inputFare){
        BigDecimal fare = inputFare;
        BigDecimal rate;
        switch (ticket.getVehicle().getSize()) {
            case MEDIUM:
                rate = MEDIUM_VEHICLE_RATE;
                break;
            case LARGE:
                rate = LARGE_VEHICLE_RATE;
                break;
            case SMALL:
                rate = SMALL_VEHICLE_RATE;
                break;       
            default:
                rate = SMALL_VEHICLE_RATE;
                break;
        }
        fare = fare.add(rate.multiply(ticket.calculateParkingDuration()==BigDecimal.ZERO?new BigDecimal("60"):ticket.calculateParkingDuration()));
        // System.out.println("BaseFareStrategy: Calculated Parking Duration for vehicle " + ticket.calculateParkingDuration());
        return fare;
    }
    
}
