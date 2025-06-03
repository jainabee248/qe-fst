package activities;

public class CustomException extends Exception {

    // Private variable to hold the custom message
    private String message;

    // Constructor that initializes the message variable
    public CustomException(String message) {
        this.message = message;
    }

    // Overriding the getMessage() method to return the custom message
    @Override
    public String getMessage() {
        return message;
    }
}
