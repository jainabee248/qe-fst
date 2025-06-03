import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity7 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the dynamic controls page
        driver.get("https://training-support.net/webelements/dynamic-controls");

        // Get and print the title of the page
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Find the input text field
        WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));

        // Check if the text field is enabled
        System.out.println("Input field enabled (before click): " + inputField.isEnabled());

        // Click the "Enable Input" button
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable Input']"));
        enableButton.click();

        // Check if the text field is enabled again
        System.out.println("Input field enabled (after click): " + inputField.isEnabled());

        // Close the browser
        driver.quit();
    }
}
