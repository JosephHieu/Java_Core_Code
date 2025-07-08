package PolymorphismChallenge;

public class Main {

    public static void main(String[] args) {

        Car car = new Car("2022 Blue Ferrari 296 GTS");
        runRace(car);

        Car ferrari = new GasPoweredCar("2023 Blue Ferrari 296 GTS",
                25.4, 6);
        runRace(ferrari);

        Car tesla = new ElectricCar("2022 Blue Ferrari", 568, 75);
        runRace(tesla);

    }

    public static void runRace(Car car) {

        car.startEngine();
        car.drive();
    }
}
