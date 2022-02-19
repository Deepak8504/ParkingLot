import java.util.List;

//Represents parking strategy of first come first serve
public class FirstComeFirstServe implements ParkingStrategy {
    @Override
    public ParkingLot getParkingLot(List<ParkingLot> parkingLots, ParkingLot lastParkingLot) {
        return ParkingStrategy.getFirstParkingLotFromList(parkingLots);
    }
}
