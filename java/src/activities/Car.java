package activities;

public class Car {
    // Variables
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    // Constructor
    Car() {
        tyres = 4;
        doors = 4;
    }

    // Method to display characteristics
    public void displayCharacteristics() {
        System.out.println("Car Characteristics:");
        System.out.println("Color: " + color);
        System.out.println("Transmission: " + transmission);
        System.out.println("Make: " + make);
        System.out.println("Tyres: " + tyres);
        System.out.println("Doors: " + doors);
    }

    // Method to accelerate
    public void accelerate() {
        System.out.println("Car is moving forward.");
    }

    // Method to brake
    public void brake() {
        System.out.println("Car has stopped.");
    }
}

