//Represents one of stakeholders of the parking lot
public class ParkingLotOwner implements Subscriber{
    private String message;


    @Override
    public String notification() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

}
