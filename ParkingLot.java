import java.util.ArrayList;
import java.util.List;

// Represent area intended for parking vehicles
public class ParkingLot {

    private final int parkingLotSize;
    private int numberOfSpotsOccupied;
    private List<Subscriber> subscriberList;
    private List<Vehicle> vehiclesParked;

    public ParkingLot(int parkingLotSize) {
        this.parkingLotSize = parkingLotSize;
        subscriberList = new ArrayList<>();
        vehiclesParked = new ArrayList<>();
    }

    public boolean isSlotAvailable() {
        return numberOfSpotsOccupied < parkingLotSize;
    }

    public int numberOfOccupiesSpots() {
        return numberOfSpotsOccupied;
    }

    public int getParkingLotSize() {
        return parkingLotSize;
    }

    public void addSubscriber(Subscriber subscriber) {
        this.subscriberList.add(subscriber);
    }

    public String getMessageOfParkingOwnerSubscriber() {
        return subscriberList.get(0).notification();
    }

    public String parkVehicle(Vehicle vehicle) {
        if (numberOfSpotsOccupied == parkingLotSize) {
            subscriberList.get(0).setMessage("ParkingLot is full");
            return "ParkingLot is Full";
        }
        vehiclesParked.add(vehicle);
        numberOfSpotsOccupied += 1;
        return "Vehicle Successfully Parked";
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        if (!vehiclesParked.contains(vehicle)) {
            return false;
        }
        vehiclesParked.remove(vehicle);
        numberOfSpotsOccupied -= 1;
        return true;
    }
}
