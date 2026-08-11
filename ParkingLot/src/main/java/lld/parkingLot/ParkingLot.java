package lld.parkingLot;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lld.parkingLot.FareCalculator.FareCalculator;
import lld.parkingLot.FareCalculator.FareStrategy.FareStrategy;
import lld.parkingLot.FareCalculator.FareStrategy.Implementation.BaseFareStrategy;
import lld.parkingLot.FareCalculator.FareStrategy.Implementation.PeakHourFareStrategy;
import lld.parkingLot.ParkingSpot.ParkingSpot;
import lld.parkingLot.Vehicle.Vehicle;
import lld.parkingLot.Vehicle.VehicleSize;
import lld.parkingLot.Vehicle.Implemetation.Car;
import lld.parkingLot.Vehicle.Implemetation.Motorcycle;
import lld.parkingLot.Vehicle.Implemetation.Truck;
import lld.parkingLot.ParkingSpot.Implementation.CompactSpot;
import lld.parkingLot.ParkingSpot.Implementation.RegularSpot;
import lld.parkingLot.ParkingSpot.Implementation.OversizedSpot;


public class ParkingLot {

    public static void main(String[] args) {
        System.out.println("Parking Lot Application Started");

        List<ParkingSpot> compactSpots = new ArrayList<>();
        List<ParkingSpot> regularSpots = new ArrayList<>();
        List<ParkingSpot> oversizedSpots = new ArrayList<>();

        compactSpots.add(new CompactSpot(1));
        compactSpots.add(new CompactSpot(2));
        regularSpots.add(new RegularSpot(3));
        regularSpots.add(new RegularSpot(4));
        oversizedSpots.add(new OversizedSpot(5));

        ParkingManager parkingManagerMain = new ParkingManager(Map.of(
            VehicleSize.SMALL, compactSpots,
            VehicleSize.MEDIUM, regularSpots,
            VehicleSize.LARGE, oversizedSpots
        ));

        FareCalculator fareCalculatorMain = new FareCalculator(new ArrayList<FareStrategy>(List.of(new BaseFareStrategy(), new PeakHourFareStrategy()))); // Add your fare strategies here

        ParkingLot parkingLot = new ParkingLot(parkingManagerMain, fareCalculatorMain);

        Ticket tt1 = parkingLot.enterVehicle(new Car("ABC123"));
        System.out.println("Ticket ID for vehicle ABC123: " + tt1.getTicketId() + " at spot number: " + tt1.getParkingSpot().getSpotNumber());
        Ticket tt2 = parkingLot.enterVehicle(new Motorcycle("XYZ789"));
        System.out.println("Ticket ID for vehicle XYZ789: " + tt2.getTicketId() + " at spot number: " + tt2.getParkingSpot().getSpotNumber());
        Ticket tt3 = parkingLot.enterVehicle(new Truck("DEF456"));
        System.out.println("Ticket ID for vehicle DEF456: " + tt3.getTicketId() + " at spot number: " + tt3.getParkingSpot().getSpotNumber());
        parkingLot.leaveVehicle(tt1);
        // Ticket tt4 = parkingLot.enterVehicle(new Truck("GHI789")); // This should print "No available parking spot for vehicle: GHI789"
        // System.out.println("Ticket ID for vehicle GHI789: " + tt4.getTicketId() + " at spot number: " + tt4.getParkingSpot().getSpotNumber());

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
