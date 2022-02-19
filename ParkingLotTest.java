import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void shouldGiveTrueIfSpotIsAvailable() {
        ParkingLot parkingLot = new ParkingLot(1);

        boolean availabilityOfEmptySpots = parkingLot.isSlotAvailable();

        Assert.assertEquals(true,availabilityOfEmptySpots);
    }

    @Test
    public void shouldBeAbleToParkOneVehicleIfSpotIsAvailable(){
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle honda = new Vehicle(1);

        parkingLot.parkVehicle(honda);
        int oneSpotIsOccupied = parkingLot.numberOfOccupiesSpots();

        Assert.assertEquals(1,oneSpotIsOccupied);
    }

    @Test
    public void shouldBeAbleToUnParkOneVehicle(){
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle honda = new Vehicle(1);

        parkingLot.parkVehicle(honda);
        parkingLot.unParkVehicle(honda);

        int zeroSpotIsOccupied = parkingLot.numberOfOccupiesSpots();

        Assert.assertEquals(0,zeroSpotIsOccupied);
    }

    @Test
    public void shouldGiveAMessageWhenParkingLotIsFull(){
        ParkingLot parkingLot = new ParkingLot(1);

        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        Vehicle honda = new Vehicle(1);
        parkingLot.addSubscriber(parkingLotOwner);
        parkingLot.parkVehicle(honda);

        String expectedStringWhenParkingLotIsFull = "ParkingLot is Full";

        String parkingLotIsFull = parkingLot.parkVehicle(honda);

        Assert.assertEquals(expectedStringWhenParkingLotIsFull,parkingLotIsFull);
    }

    @Test
    public void shouldNotifyParkingOwnerSubscriber(){
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        Vehicle honda = new Vehicle(1);
        Vehicle maruti = new Vehicle(2);
        parkingLot.addSubscriber(parkingLotOwner);
        parkingLot.parkVehicle(honda);
        parkingLot.parkVehicle(maruti);

        String expectedStringWhenParkingLotIsFull = "ParkingLot is full";
        String parkingLotIsFull = parkingLot.getMessageOfParkingOwnerSubscriber();

        Assert.assertEquals(expectedStringWhenParkingLotIsFull,parkingLotIsFull);
    }

    @Test
    public void shouldNotUnparkVehicleIfItsNotPresent() {
        ParkingLot parkingLot = new ParkingLot(1);

        Vehicle honda = new Vehicle(1);

        Assert.assertFalse(parkingLot.unParkVehicle(honda));
    }
}
