package SpeedRacing;

public class Car {
    private String name;
    private double fuelAmount;
    private double fuelConsumption;
    private double distanceTraveled;

    public Car(String name, double fuelAmount, double fuelConsumption) {
        this.name = name;
        this.fuelAmount = fuelAmount;
        this.fuelConsumption = fuelConsumption;
        this.distanceTraveled = 0;
    }

    public boolean drive(double kilometersToDrive) {
        double fuelRequired = kilometersToDrive * fuelConsumption;
        if (fuelRequired > fuelAmount) {
            return false;
        } else {
            fuelAmount -= fuelRequired;
            distanceTraveled += kilometersToDrive;
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", name, fuelAmount, distanceTraveled);
    }
}
