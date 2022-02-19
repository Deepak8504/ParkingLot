import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingAttendeeTest {
    @Test
    public void shouldBeAbleToParkWithHelpOfParkingAttendeeInFirstParkingLot() {
        List<ParkingLot> listOfParkingLots = createListOfParkingLots();
        ParkingAttendee parkingAttendee = new ParkingAttendee(listOfParkingLots);
        Vehicle vehicle = new Vehicle(1);

        parkingAttendee.parkVehicle(vehicle, new FirstComeFirstServe());
        int oneSpotIsOccupied = listOfParkingLots.get(0).numberOfOccupiesSpots();

        Assert.assertEquals(1, oneSpotIsOccupied);
    }

    @Test
    public void parkingAttendeeShouldBeAbleToParkVehicle() {
        List<ParkingLot> listOfParkingLots = createListOfParkingLots();
        ParkingAttendee parkingAttendee = new ParkingAttendee(listOfParkingLots);
        Vehicle honda = new Vehicle(1);
        parkingAttendee.parkVehicle(honda, new FirstComeFirstServe());

        ParkingLot parkingLot = listOfParkingLots.get(0);

        Assert.assertEquals(1, parkingLot.numberOfOccupiesSpots());
    }

    @Test
    public void parkingAttendeeShouldBeAbleToUnParkVehicle() {
        List<ParkingLot> listOfParkingLots = createListOfParkingLots();
        ParkingAttendee parkingAttendee = new ParkingAttendee(listOfParkingLots);
        Vehicle honda = new Vehicle(1);
        parkingAttendee.parkVehicle(honda, new FirstComeFirstServe());

        parkingAttendee.unParkVehicle(honda);
        ParkingLot parkingLot = listOfParkingLots.get(0);

        Assert.assertEquals(0, parkingLot.numberOfOccupiesSpots());
    }

    @Test
    public void parkingAttendeeShouldBeAbleToParkAtAnyParkingLot() {
        ParkingLot smallLot = new ParkingLot(1);
        ParkingLot largeLot = new ParkingLot(1);
        List<ParkingLot> listOfParkingLots = new ArrayList<>();
        listOfParkingLots.add(smallLot);
        listOfParkingLots.add(largeLot);
        ParkingAttendee parkingAttendee = new ParkingAttendee(listOfParkingLots);
        Vehicle honda = new Vehicle(1);

        parkingAttendee.parkVehicle(honda, smallLot);

        Assert.assertFalse(smallLot.isSlotAvailable());
    }

    @Test
    public void parkingAttendeeShouldBeAbleToParkAtMaximumSizeParkingLot() {
        ParkingLot parkingLotNearHome = new ParkingLot(5);
        ParkingLot parkingLotNearCompany = new ParkingLot(10);
        List<ParkingLot> listOfParkingLots = new ArrayList<>();
        listOfParkingLots.add(parkingLotNearHome);
        listOfParkingLots.add(parkingLotNearCompany);
        ParkingAttendee parkingAttendee = new ParkingAttendee(listOfParkingLots);

        Vehicle honda = new Vehicle(1);
        parkingAttendee.parkVehicle(honda, new MaximumSizeLotFirst());

        Assert.assertEquals(1, parkingLotNearCompany.numberOfOccupiesSpots());
    }

    @Test
    public void parkingAttendeeShouldBeAbleToParkInRoundRobinFashion() {
        ParkingLot smallLot = new ParkingLot(5);
        ParkingLot mediumLot = new ParkingLot(10);
        ParkingLot largeLot = new ParkingLot(20);
        List<ParkingLot> listOfParkingLots = new ArrayList<>();
        listOfParkingLots.add(smallLot);
        listOfParkingLots.add(mediumLot);
        listOfParkingLots.add(largeLot);
        ParkingAttendee parkingAttendee = new ParkingAttendee(listOfParkingLots);

        Vehicle honda = new Vehicle(1);
        parkingAttendee.parkVehicle(honda, new RoundRobin());
        parkingAttendee.unParkVehicle(honda);
        parkingAttendee.parkVehicle(honda, new RoundRobin());

        Assert.assertEquals(1, mediumLot.numberOfOccupiesSpots());
    }

    public List<ParkingLot> createListOfParkingLots() {
        List<ParkingLot> listOfParkingLot = new ArrayList<>();
        listOfParkingLot.add(createParkingLot(5));
        listOfParkingLot.add(createParkingLot(10));
        return listOfParkingLot;
    }

    public ParkingLot createParkingLot(int capacity) {
        return new ParkingLot(capacity);
    }
}
