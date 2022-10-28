class ParkingLot {
  
  List<ParkingFloor> parkingFloors;
  List<Entrance> entrances;
  List<Exit> exist;

  Address address;
  String parkingLotName;

  public boolean isParkingSpaceAvailable(Vehicle vehicle){}
  public boolean updateParkingAttendant(ParkingAttendant parkingAttendant, int gateId){}

}

class ParkingFloor {
  
  int levelId;
  boolean isFull;
  List<ParkingSpace> parkingspaces;

  ParkingDisplayBoard parkingDisplayBoard;

}

class Gate {

  int gateId;
  ParkingAttendant parkingAttendant;

}

class Entrance extends Gate {

  public ParkingTicket getParkingTicket(Vehicle vehicle){}

}

class Exit {

  public ParkingTicket payForParking(ParkingTicket parkingTicket, PaymentType paymentType){}

}

class Address {

  String country;
  String state;
  String city;
  String street;
  String pincode;

}

class ParkingSpace {

  int spaceId;
  boolean isFree;
  double costPerHour;
  Vehicle vehicle;
  ParkingSpaceType parkingSpaceType;

}

class ParkingDisplayBoard {

  Map<ParkingSpaceType, Integer> freeSpotsAvailableMap;

  public void updateFreeSpotsAvailable(ParkingSpaceType parkingSpaceType, int spaces){}

}

class Account {

  String name;
  String email;
  String password;
  String empId;
  String address;

}

class Admin extends Account {

  public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor){}
  public boolean addParkingSpace(ParkingFloor parkingFloor, ParkingSpace parkingSpace){}
  public boolean addParkingDisplayBoard(ParkingFloor parkingFloor, ParkingDisplayBoard parkingDisplayBoard){}

}

class ParkingAttendant extends Account {

  Payment paymentService;

  public boolean processVehicleEntry(Vehicle vehicle){}
  public PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType){}

}

class Vehicle {

  String licenseNumbe;
  VehicleType vehicleType;
  ParkingTicket parkingTicket;
  PaymentInfo paymentInfo;

}

class ParkingTicket {

  int ticketId;
  int levelId;
  int spaceId;
  Date vehicleEntryDateTime;
  Date vehicleExitDateTime;
  ParkingSpaceType parkingSpaceType;
  double totalCost;
  ParkingTicketStatus parkingTicketStatus;

  public void updateTotalCost(){}
  public void updateVehicleExitTime(Date vehicleExitDateTime){}

}

class Payment {

  public PaymentInfo makePayment(ParkingTicket parkingTicket, PaymentType paymentType){}

}

class PaymentInfo {

  double amount;
  Date paymentDate;
  int transactionId;
  ParkingTicket parkingTicket;
  PaymentStatus paymentStatus; 

}

enum PaymentType {

  CASH, CREDIT_CARD, DEBIT_CARD, UPI;

}

enum ParkingSpaceType {

    BIKE_PARKING, CAR_PARKING, TRUCK_PARKING

}

enum VehicleType {

  BIKE, CAR, TRUCK

}

enum ParkingTicketStatus {

  PAID, ACTIVE

}

enum PaymentStatus {

  UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;

}