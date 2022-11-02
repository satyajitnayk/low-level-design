
public class ParkingSlot {

  String name;
  boolean isAvailable = true;
  Vehicle vehicle;
  ParkingSlotType parkingSlotType;

  public ParkingSlot(String name, ParkingSlotType parkingSlotType) {
    this.name = name;
    this.parkingSlotType = parkingSlotType;
  }

  protected void addVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
    this.isAvailable = false;
  }

  protected void removeVehicle(Vehicle vehicle) {
    this.vehicle = null;
    this.isAvailable = true;
  }

  public ParkingSlotType getParkingSloType() {
    return this.parkingSlotType;
  }
}
