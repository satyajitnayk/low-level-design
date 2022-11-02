
public class Ticket {

  String ticketNumber;
  long startTime;
  long endTime;
  Vehicle vehicle;
  ParkingSlot parkingSlot;

  public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
    return Ticket.builder()
        .parkingSlot(parkingSlot)
        .startTime(System.currentTimeMillis())
        .vehicle(vehicle)
        .ticketNumber(vehicle.getVehicleNumber() + System.currentTimeMillis())
        .build();
  }

  public ParkingSlot getParkingSlot() {
    return this.parkingSlot;
  }

  public Vehicle getVehicle() {
    return this.vehicle;
  }

  public long getStartTime() {
    return this.startTime;
  }
}
