import java.util.List;

//Represents functions to be implemented in every Parking strategy
interface ParkingStrategy {
    public ParkingLot getParkingLot(List<ParkingLot> parkingLots, ParkingLot lastParkingLot);

    public static ParkingLot getFirstParkingLotFromList(List<ParkingLot> parkingLots) {
        for(ParkingLot parkingLot: parkingLots) {
            if(parkingLot.isSlotAvailable()) {
                return parkingLot;
            }
        }
        return null;
    }
}
