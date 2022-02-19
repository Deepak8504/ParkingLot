import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Represents entity which parks and unparks vehicle for the user
public class ParkingAttendee {
    private List<ParkingLot> parkingLots;
    private ParkingLot lastParkingLot;

    public ParkingAttendee(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        lastParkingLot = parkingLots.get(parkingLots.size() - 1);
    }

    public boolean parkVehicle(Vehicle vehicle, ParkingStrategy parkingStrategy) {
        List<ParkingLot> parkingLots = new ArrayList<>(this.parkingLots);
        ParkingLot parkingLot = parkingStrategy.getParkingLot(parkingLots, lastParkingLot);
        if (parkingLot == null) {
            return false;
        }
        if (parkingStrategy.getClass().equals(RoundRobin.class)) {
            lastParkingLot = parkingLot;
        }
        parkingLot.parkVehicle(vehicle);
        return true;
    }

    public boolean parkVehicle(Vehicle vehicle, ParkingLot parkingLot) {
        if (parkingLots.contains(parkingLot)) {
            int index = parkingLots.indexOf(parkingLot);
            parkingLots.get(index).parkVehicle(vehicle);
            return true;
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.unParkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }
}

class SortInDescByCapacity implements Comparator<ParkingLot> {
    public int compare(ParkingLot parkingLot1, ParkingLot parkingLot2) {
        return parkingLot2.getParkingLotSize() - parkingLot1.getParkingLotSize();
    }
}