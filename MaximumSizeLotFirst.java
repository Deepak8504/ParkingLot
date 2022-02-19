import java.util.List;

//Represents parking strategy where maximum size slot will be assigned first
public class MaximumSizeLotFirst implements ParkingStrategy {
    @Override
    public ParkingLot getParkingLot(List<ParkingLot> parkingLots, ParkingLot lastParkingLot) {
        parkingLots.sort(new SortInDescByCapacity());
        return ParkingStrategy.getFirstParkingLotFromList(parkingLots);
    }
}
