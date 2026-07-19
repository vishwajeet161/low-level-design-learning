package lld.parkingLot;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lld.parkingLot.FareCalculator.FareCalculator;
import lld.parkingLot.ParkingSpot.ParkingSpot;
import lld.parkingLot.Vehicle.Vehicle;

public class ParkingLot {

    public static void main(String[] args) {
        System.out.println("Parking Lot Application Started");
    } 


    private final ParkingManager parkingManager;

    private final FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator) {
        this.parkingManager = parkingManager;
        this.fareCalculator = fareCalculator;
    }

    public Ticket enterVehicle(Vehicle vehicle){
        ParkingSpot spot = parkingManager.parkVehicle(vehicle);

        if(spot != null){
            Ticket ticket = new Ticket(generateTicketId(), vehicle, spot, LocalDateTime.now());
            return ticket;
        }
        else{
            System.out.println("No available parking spot for vehicle: " + vehicle.getLicensePlate());
            return null;
        }
    }

    public void leaveVehicle(Ticket ticket){
        if(ticket !=null && ticket.getExitTime() ==null){
            ticket.setExitTime(LocalDateTime.now());
            parkingManager.unparkVehicle(ticket.getVehicle());
            
            BigDecimal fare = fareCalculator.calculateFare(ticket);
            System.out.println("Vehicle with license plate " + ticket.getVehicle().getLicensePlate() + " has left the parking lot. Total Fare: " + fare + " bucks"); 
        }
        else{
            System.out.println("Invalid ticket or vehicle has already left.");

        }
    }

    private String generateTicketId() {
        return "TICKET-" + System.currentTimeMillis();
    }
    
}
