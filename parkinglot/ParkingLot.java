import java.util.List;
import java.util.Map;

public class ParkingLot {

  private String nameOfParkingLot;
  private Address address;
  private List<ParkingFloor> parkingFloors;
  private static ParkingLot parkingLot = null;

  private ParkingLot(String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors) {
    this.address = address;
    this.nameOfParkingLot = nameOfParkingLot;
    this.parkingFloors = parkingFloors;
  }

  public static ParkingLot getInstance(String nameOfParkinggLot, Address address, List<ParkingFloor> parkingFloors) {
    if (parkingLot == null) {
      parkingLot = new ParkingLot(nameOfParkinggLot, address, parkingFloors);
    }
    return parkingLot;
  }

  public void addFloors(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
    ParkingFloor parkingFloor = new ParkingFloor(name, parkingSlots);
    parkingFloors.add(parkingFloor);
  }

  public void removeFloors(ParkingFloor parkingFloor) {
    parkingFloors.remove(parkingFloor);
  }

  public Ticket assignTicket(Vehicle vehicle) {
    ParkingSlot parkingSlot = getParkingSlotForVehicleAndPark(vehicle);
    if (parkingSlot == null)
      return null;

    Ticket parkingTicket = createTicketForSlot(parkingSlot, vehicle);
    return parkingTicket;
  }

  private Ticket createTicketForSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
    return Ticket.createTicket(vehicle, parkingSlot);
  }

  private ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle) {
    ParkingSlot parkingSlot = null;
    for (ParkingFloor floor : parkingFloors) {
      parkingSlot = floor.getRelevantSlotForVehicleAndPark(vehicle);
      if (parkingSlot != null)
        break;
    }

    return parkingSlot;
  }

  public double scanAndPay(Ticket ticket) {
    long endTime = System.currentTimeMillis();
    ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
    int duration = (int) (endTime - ticket.getStartTime()) / 1000;
    double price = ticket.getParkingSlot().getParkingSloType().getPriceForParking(duration);
    // persist the data to database
    return price;
  }

}
