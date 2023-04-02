package builder.cars.components;

import builder.cars.Car;

public class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel(){
        System.out.println(car.getFuel());
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.printf("Car isn't started");
        }
    }
}
