package activities;

public class Activity1 {
    public static void main(String[] args) {
        // Create an object of the Car class
        Car carName = new Car();

        // Initialize values
        carName.make = 2014;
        carName.color = "Black";
        carName.transmission = "Manual";

        // Call methods
        carName.displayCharacteristics();
        carName.accelerate();
        carName.brake();
    }
}
