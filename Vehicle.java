import java.util.Objects;

public class Vehicle {
    int vehicleId;

    public Vehicle(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return this.vehicleId == vehicle.vehicleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId);
    }
}
