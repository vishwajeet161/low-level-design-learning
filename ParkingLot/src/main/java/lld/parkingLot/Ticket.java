package lld.parkingLot;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

import lld.parkingLot.ParkingSpot.ParkingSpot;
import lld.parkingLot.Vehicle.Vehicle;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;

    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, LocalDateTime entryTime){
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
    }

    public BigDecimal calculateParkingDuration(){
        return new BigDecimal(Duration.between(entryTime, Objects.requireNonNullElseGet(exitTime, LocalDateTime::now)).toMinutes());
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public ParkingSpot getParkingSpot(){
        return parkingSpot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }


}
