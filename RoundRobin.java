import java.util.List;

//Represents round robin parking strategy where each slot is filled consecutively
public class RoundRobin implements ParkingStrategy {
    int FIRST_LOT = 0;

    @Override
    public ParkingLot getParkingLot(List<ParkingLot> parkingLots, ParkingLot lastParkingLot) {
        int indexOfLastParkingLot = parkingLots.indexOf(lastParkingLot);
        if (indexOfLastParkingLot == parkingLots.size() - 1) {
            return parkingLots.get(FIRST_LOT);
        } else {
            return parkingLots.get(indexOfLastParkingLot + 1);
        }
    }
}
