package builder.cars;

import builder.cars.components.Engine;
import builder.cars.components.GPSNavigator;
import builder.cars.components.Transmission;
import builder.cars.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
