package PolymorphismChallenge;

public class Car {

    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("Car -> startEngine");
    }

    protected void runEngine() {
        System.out.println("Car -> runEngine");
    }

    public void drive() {
        System.out.println("Car -> driving, type is " + getClass().getSimpleName());
        runEngine();
    }
}

class GasPoweredCar extends Car {

    private double aveKmPerLiter;
    private int cylinders = 6;


    public GasPoweredCar(String description) {
        super(description);
    }

    public GasPoweredCar(String description, double aveKmPerLiter, int cylinders) {
        super(description);
        this.aveKmPerLiter = aveKmPerLiter;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.printf("Gas -> All %d cylinders are fired up, Ready!%n", cylinders);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Gas -> usage exceeds the average: %.2f %n", aveKmPerLiter);
    }
}

class ElectricCar extends Car {

    private double averageKmPerCharge;
    private int batterySize = 6;


    public ElectricCar(String description) {
        super(description);
    }

    public ElectricCar(String description, double averageKmPerCharge, int batterySize) {
        super(description);
        this.averageKmPerCharge = averageKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        System.out.printf("BEV -> switch %d kWh battery on, Ready!%n", batterySize);
    }

    @Override
    protected void runEngine() {
        System.out.printf("BEV -> usage under the average: %.2f %n", averageKmPerCharge);
    }
}

class HybridCar extends Car {

    private double aveKmPerLiter;
    private int cylinders = 6;
    private int batterySize;


    public HybridCar(String description) {
        super(description);
    }

    public HybridCar(String description, double aveKmPerLiter, int cylinders,
                     int batterySize) {
        super(description);
        this.aveKmPerLiter = aveKmPerLiter;
        this.cylinders = cylinders;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        System.out.printf("Hybrid -> %d cylinders are fired up.%n", cylinders);
        System.out.printf("Hybrid -> switch %d kWh battery on, Ready!%n", batterySize);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Hybrid -> usage below average: %.2f %n", aveKmPerLiter);
    }
}
